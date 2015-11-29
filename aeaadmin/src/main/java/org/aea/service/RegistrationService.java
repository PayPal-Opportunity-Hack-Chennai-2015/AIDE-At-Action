/**
 * 
 */
package org.aea.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.aea.dto.Address;
import org.aea.dto.FamilyRegistration;
import org.aea.dto.School;
import org.aea.dto.User;
import org.aea.dto.Worksite;
import org.aea.entity.Family;
import org.aea.entity.Person;
import org.aea.repo.AddressRepo;
import org.aea.repo.FamilyRepository;
import org.aea.repo.PersonRepo;
import org.aea.repo.SchoolRepo;
import org.aea.repo.WorksiteRepository;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Prasad
 *
 */
@Service
public class RegistrationService {

  @Autowired
  private WorksiteRepository workRepo;

  @Autowired
  private SchoolRepo schoolRepo;

  @Autowired
  private DateUtils dateUtil;

  @Autowired
  private PersonRepo personRepo;

  @Autowired
  private AddressRepo addrRepo;

  @Autowired
  private FamilyRepository familyRepo;

  /**
   * @return
   */
  public List<Worksite> getAllWorksites() {
    List<Worksite> sites = new ArrayList<Worksite>();
    List<org.aea.entity.Worksite> works = workRepo.findAll();
    if (works != null && !works.isEmpty()) {
      for (org.aea.entity.Worksite wk : works) {
        Worksite work = new Worksite();
        work.setName(wk.getName());
        work.setId(wk.getId());
        sites.add(work);
      }
    }
    return sites;
  }

  /**
   * @param region
   * @return
   */
  public List<School> getAllSchool(String region) {

    List<School> sites = new ArrayList<School>();
    List<org.aea.entity.School> works = schoolRepo.findAll();
    if (works != null && !works.isEmpty()) {
      for (org.aea.entity.School wk : works) {
        School work = new School();
        work.setName(wk.getContact());
        work.setId(wk.getId());
        sites.add(work);
      }
    }
    return sites;

  }

  /**
   * @param registration
   */
  public void save(FamilyRegistration registration) {
    User familyHead = registration.getFamilyHead();
    if (familyHead != null) {
      Person head = buildUserEntity(familyHead);
      head = personRepo.save(head);

      if (head != null) {
        org.aea.entity.Address addr = new org.aea.entity.Address();
        Address address = registration.getAddress();
        if (address != null) {
          addr.setCity(address.getBlock());
          addr.setDistrict(address.getDistrict());
          addr.setFline(address.getGp());
          addr.setRegion(address.getVillage());
          addr.setState(address.getState());
          addr.setZip(address.getPin());
          addr = addrRepo.save(addr);
        }
        org.aea.entity.Worksite work = new org.aea.entity.Worksite();
        int wk = registration.getWork();
        work = workRepo.findOne(wk);
        Family f = new Family();
        f.setAddress1(addr);
        f.setAddress2(addr);
        f.setCategory(registration.getCategory());
        f.setFamilyId(generateID(head));
        f.setPerson(head);
        f.setWorksiteBean(work);
        f.setRegistration(new Date());

        f = familyRepo.save(f);
        head.setFamilyID(f.getId());
        personRepo.save(head);
        if (registration.getFamily() != null) {
          for (User usr : registration.getFamily()) {
            Person person = buildUserEntity(usr);
            if (person != null) {
              if (usr.getRelation().equalsIgnoreCase("WIFE")) {
                person.setPregnencay(usr.getIsPregrant());
                // if(usr.getExpectedDelivery() != null){
                // person.set
                // }
              } else {

              }
              person.setFamilyID(f.getId());
              person = personRepo.save(person);
            }
          }
        }
      }
    }
  }

  private String generateID(Person head) {
    String curDate = dateUtil.getCurDateAsString(new LocalDate());
    int pick = new Random().nextInt(900) + 100;
    return curDate + pick;
  }

  private Person buildUserEntity(User familyHead) {
    Person head = new Person();
    head.setFname(familyHead.getName());
    head.setAge(familyHead.getAge());
    head.setGender(familyHead.getGender());
    head.setTitle(familyHead.getRelation());
    if (familyHead.getDob() != null) {
      DateTime dobDate =
          dateUtil.getFormattedPaymentDate(familyHead.getDob(), DateUtils.ddMMyyyy_FSLSH);
      if (dobDate != null) {
        head.setDob(dobDate.toDate());
        head.setAge(Years.yearsBetween(dobDate, DateTime.now()).getYears());
      }
    }

    return head;
  }

  public void addschool(org.aea.entity.School registration) {
    // TODO Auto-generated method stub

  }

  public void addwork(Worksite registration) {
    // TODO Auto-generated method stub

  }

  public FamilyRegistration getFamilyDetails(String familyID) {
    FamilyRegistration reg = new FamilyRegistration();
    List<Family> families = familyRepo.findByFamilyId(familyID);
    if (families != null && !families.isEmpty()) {
      Family family = families.get(0);

      // Person head = family.getPerson();
      // User headUser = buildUser(head);
      // if(headUser != null){
      // reg.setFamilyHead(headUser);
      org.aea.entity.Address addressE = family.getAddress1();
      Address primaryAddr = buildAddrModel(addressE);
      reg.setAddress(primaryAddr);
      reg.setCategory(family.getCategory());
      org.aea.entity.Worksite work = family.getWorksiteBean();
      if (work != null) {
        reg.setWork(work.getId());
        reg.setWorkName(work.getName());
      }
      reg.setFamily(new ArrayList<User>());
      List<Person> persons = personRepo.findByFamilyID(family.getId());
      if (persons != null && !persons.isEmpty()) {
        for (Person person : persons) {
          User user = buildUser(person);
          if (user.getRelation() == null) {
            reg.setFamilyHead(user);
          } else {
            reg.getFamily().add(user);
          }
        }
      }
    }

    return reg;
  }

  private Address buildAddrModel(org.aea.entity.Address addressE) {
    Address addr = new Address();
    if (addressE != null) {
      addr.setBlock(addressE.getCity());
      addr.setDistrict(addressE.getDistrict());
      addr.setGp(addressE.getFline());
      addr.setVillage(addressE.getRegion());
      addr.setState(addressE.getState());
      addr.setPin(addressE.getZip());
    }

    return addr;
  }

  private User buildUser(Person person) {
    User user = new User();
    if (person != null) {
      user.setAge(person.getAge());
      user.setGender(person.getGender());
      user.setName(person.getFname());
      user.setIsPregrant(person.getPregnencay());
      user.setRelation(person.getTitle());
      return user;
    }
    return user;
  }
}
