/**
 * 
 */
package org.aea.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.aea.entity.Address;
import org.aea.entity.Family;
import org.aea.entity.Person;
import org.aea.entity.Worksite;
import org.aea.repo.FamilyRepository;
import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer.CConvertException;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * @author Prasad
 *
 */
@Service
public class TemplateHelper {

  // private static String PATH_TO_TEMPLATE = "/opt/templates";
  // private static String PATH_TO_TEMPLATE = "C:\\Users\\user\\git\\DE\\DecisionEngine";

  private static final String ASSESMENT_TEMPLATE = "assessment-print.vm";

  @Autowired
  private FamilyRepository repo;
  
  @PostConstruct
  public void inint() {
    Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");
    // Velocity.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, PATH_TO_TEMPLATE);
    Velocity.setProperty("class.resource.loader.class", ClasspathResourceLoader.class.getName());
    Velocity.init();
  }

  /**
   * @param params
   * @return
   */
  public String bindTemlate(Map<String, String> params, String family) {
    try {
      Template t = Velocity.getTemplate(ASSESMENT_TEMPLATE);
      VelocityContext context = new VelocityContext();
      for (String key : params.keySet()) {
        context.put(key, params.get(key));
      }
      StringWriter writer = new StringWriter();
      t.merge(context, writer);

      return writer.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public void buildPDF(String html) {
    // step 1
    Document document = new Document();
    // step 2
    PdfWriter writer;
    try {
      writer = PdfWriter.getInstance(document, new FileOutputStream("pdf_sathish9.pdf"));
      // step 3
      document.open();
      // step 4
      InputStream stream = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
      XMLWorkerHelper.getInstance().parseXHtml(writer, document, stream);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // step 5
    document.close();

    System.out.println("PDF Created!");
  }

  public void convertPDF(String html,String family) {
    CYaHPConverter converter = new CYaHPConverter();
    FileOutputStream out = null;
    try {
      // File fout = new File("c:/temp/x.pdf");
      out = new FileOutputStream(family);
      Map<String, String> properties = new HashMap<String, String>();
      List headerFooterList = new ArrayList();

      String str = "<HTML><HEAD></HEAD><BODY><H1>Testing</H1><FORM>"
          + "check : <INPUT TYPE='checkbox' checked=checked/><br/>" + "</FORM></BODY></HTML>";

      properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS,
          IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);
      // properties.put(IHtmlToPdfTransformer.FOP_TTF_FONT_PATH, fontPath);
      // Thread.currentThread().sleep(30*1000);
      converter.convertToPdf(html, IHtmlToPdfTransformer.A3P, headerFooterList, "file:///temp/", // root
                                                                                                 // for
                                                                                                 // relative
                                                                                                 // external
                                                                                                 // CSS
                                                                                                 // and
                                                                                                 // IMAGE
          out, properties);
      out.flush();
      out.close();
    } catch (CConvertException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      if (out != null) {
        try {
          out.flush();
          out.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

  }

  public void getDocument(String familiyId) {
    List<Family> families = repo.findByFamilyId(familiyId);
    Map<String, String> map = new HashMap<String, String>();
    if(families != null && !families.isEmpty()){
      Family family = families.get(0);
      Person head = family.getPerson();
      map.put("name", head.getFname());
      map.put("age", ""+head.getAge());
      map.put("gender", head.getGender() == 0 ? "MALE" : "FEMALE");
//      map.put("cate", value)
      Worksite work = family.getWorksiteBean();
      if(work != null){
        map.put("work", work.getName());
        if(family.getRegistration() != null)
        map.put("start", DateUtils.ddMMyyyy_FSLSH.print(family.getRegistration().getTime()));
      }
      Address address = family.getAddress1();
      if(address != null){
        map.put("block", address.getCity());
        map.put("dist", address.getDistrict());
        map.put("gp", address.getFline());
        map.put("village", address.getRegion());
        map.put("state", address.getState());
        map.put("pin", address.getZip());
      }
      
      String html = bindTemlate(map,familiyId);
      convertPDF(html, familiyId);
    }
  }
}
