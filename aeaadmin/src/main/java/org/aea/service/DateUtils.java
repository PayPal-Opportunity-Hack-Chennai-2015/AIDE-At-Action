/**
 * 
 */
package org.aea.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Prasad
 *
 */
@Service
public class DateUtils {

  public static final DateTimeFormatter YYYYMMDD_HPN = DateTimeFormat.forPattern("yyyy-MM-dd");

  public static final DateTimeFormatter MMMMMddyyyy_HPN = DateTimeFormat.forPattern("MMMMM-dd-yyyy");
  
  public static final DateTimeFormatter MMddyyyy_FSLSH = DateTimeFormat.forPattern("MM/dd/yyyy");
  
  public static final DateTimeFormatter ddMMyyyy_FSLSH = DateTimeFormat.forPattern("dd/MM/yyyy");

  public static final DateTimeZone PACIFIC_TZ = DateTimeZone.forID("US/Pacific");


  public LocalDate getExpectedDisbursalDate() {
    DateTime dt = DateTime.now(DateTimeZone.forID("US/Pacific"));
    if (dt.getHourOfDay() < 15) {
      return getNextBusinessDate(dt);
    } else {
      dt = dt.plusDays(1);
      return getNextBusinessDate(dt);
    }
  }

  private LocalDate getNextBusinessDate(DateTime dt) {
    if(isWeekend(dt) || checkIsHoliday(dt)){
      dt = dt.plusDays(1);
      return getNextBusinessDate(dt);
    }
    return dt.toLocalDate();
  }

  private boolean isWeekend(DateTime dt) {
    if(dt.getDayOfWeek() == 6 || dt.getDayOfWeek() == 7)
      return true;
    return false;
  }

  /**
   * @param dt
   * @return
   */
  private DateTime getWeekendAdjDate(DateTime dt) {
    switch (dt.getDayOfWeek()) {
      // sat
      case 6:
        return dt.plusDays(2);
      // sun
      case 7:
        return dt.plusDays(1);
      default:
        return dt;
    }
  }

  /**
   * @param date
   * @return
   */
  public boolean checkIsHoliday(DateTime date) {
    return false;
  }

  public LocalDate getFirstRepaymentDate(int paymentfreq, Date paydate1, Date paydate2,
      Date paydate3, int afterPaydate) {

    LocalDate firstRepaymentDate = LocalDate.now();

    LocalDate first = new LocalDate(paydate1);
    LocalDate second = new LocalDate(paydate2);
    int days = Days.daysBetween(first, second).getDays();
    System.out.println("days == " + days);
    // Check needed only for first payment date occurring in the past
    if (first.isBefore(LocalDate.now())) {
      first = getAdjustedFutureDate(first, second, days, paymentfreq);
      second = new LocalDate(first).plusDays(days);
    }
    firstRepaymentDate = first;

    int datecount = getPaymentPeriodDays(paymentfreq);
    datecount = datecount + afterPaydate;
    int diff = Days.daysBetween(LocalDate.now(),first).getDays();
    if (diff < datecount / 2) {
      firstRepaymentDate = second;
    }

    firstRepaymentDate = firstRepaymentDate.plusDays(afterPaydate);

    return firstRepaymentDate;
  }

  /**
   * @param paymentfreq
   * @return
   */
  private int getPaymentPeriodDays(int paymentfreq) {
    // Case 4,5 defaults to 30
    int datecount = 30;
    switch (paymentfreq) {
      case 1:
        datecount = 14;
        break;
      case 2:
        datecount = 7;
        break;
      case 3:
        datecount = 15;
        break;
    }

    return datecount;
  }

  private LocalDate getAdjustedFutureDate(LocalDate first, LocalDate second, int days,
      int paymentfreq) {

    if (first.isBefore(LocalDate.now())) {

      if (paymentfreq == 4 || paymentfreq == 5) {
        first = first.plusMonths(1);
        second = second.plusMonths(1);
      } else {
        first = first.plusDays(days);
        second = second.plusDays(days);
      }
      System.out.println(first.toString());

      return getAdjustedFutureDate(first, second, days, paymentfreq);
    }

    return first;
  }

  public String getFormattedPaymentDate(String dateStr, DateTimeFormatter from,
      DateTimeFormatter to) {
    try {
      // Parsing the date
      DateTime dateObj = from.parseDateTime(dateStr);

      return to.print(dateObj);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dateStr;
  }

  public DateTime getFormattedPaymentDate(String dateStr, DateTimeFormatter from) {
    try {
      // Parsing the date
      DateTime dateObj = from.parseDateTime(dateStr);

      return dateObj;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String getFormattedPaymentDateString(Date date, DateTimeFormatter to) {
    try {
      // Parsing the date
      DateTime dateObj = new DateTime(date);

      return to.print(dateObj);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static long getExpiryDateTime(int hours) {
    return DateTime.now().plusHours(hours).getMillis();
  }

  public Date getExpiryDT(int days, boolean workingDays) {
    DateTime expiryDT = new DateTime(PACIFIC_TZ)/*.plusDays(1)*/.withTimeAtStartOfDay();
    if(!workingDays){
      expiryDT.plusDays(days);
    }else{
      for(int i=0;i<days;)
      {
        expiryDT = expiryDT.plusDays(1);
        switch(expiryDT.getDayOfWeek())
        {
          case DateTimeConstants.SATURDAY:
          case DateTimeConstants.SUNDAY:          
            break;
            default:
              i++;
        }
      }
    }
    return expiryDT.toDate();
  }
  
  public String getCurDateAsString(LocalDate loanDate) {
    String dt = loanDate != null
        ? Integer.toString(loanDate.getYear()) + String.format("%02d", loanDate.getMonthOfYear())
            + String.format("%02d", loanDate.getDayOfMonth())
        : "YYYYMMDD";

    return dt;
  }
}
