package org.aea;

import org.aea.dto.FamilyRegistration;
import org.aea.service.TemplateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemplateController {

  @Autowired
  TemplateHelper helper;
  
  @RequestMapping(value = "/download", method = RequestMethod.GET)
  public String loadRegistrations(@RequestParam(value = "id", required = false) String familyID,
      Model model) {
    System.out.println("Get");
    helper.getDocument(familyID);
    
    return "user-registration";
  }

}
