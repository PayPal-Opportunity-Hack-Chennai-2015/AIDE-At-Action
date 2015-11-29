/**
 * 
 */
package org.aea.service;

import java.util.HashMap;
import java.util.Map;

import org.aea.AeaadminApplicationTests;
import org.aea.repo.WorksiteRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Prasad
 *
 */
public class TemplateTest extends AeaadminApplicationTests {

  @Autowired
  DateUtils uti;
  
  @Autowired
  TemplateHelper engine;
  
  @Autowired
  WorksiteRepository repo;
  @Test
  public void testTemplate(){
    Map<String, String> params = new HashMap<String, String>();
    params.put("name", "Prasad");
    String html = engine.bindTemlate(params);
    System.out.println(html);
//    engine.buildPDF(html);
    engine.convertPDF(html);
  }
  
  @Test
  public void testWok(){
    System.out.println(repo.findAll().size());
  }
}
