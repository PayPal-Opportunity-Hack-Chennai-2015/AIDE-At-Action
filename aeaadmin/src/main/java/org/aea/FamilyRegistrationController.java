/**
 * 
 */
package org.aea;

import org.aea.dto.FamilyRegistration;
import org.aea.dto.Worksite;
import org.aea.entity.School;
import org.aea.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Prasad
 *
 */
@Controller
public class FamilyRegistrationController {

  @Autowired
  private RegistrationService register;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String loadRegistrations(@RequestParam(value = "id", required = false) String familyID,
      Model model) {
    System.out.println("Get");
    FamilyRegistration family = register.getFamilyDetails(familyID);
    model.addAttribute("allschool", register.getAllSchool(null));
    model.addAttribute("allwork", register.getAllWorksites());
    model.addAttribute("registration", family);
    
    return "user-registration";
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String addRegistration(@ModelAttribute FamilyRegistration registration, Model model) {

    System.out.println(registration);
    register.save(registration);
    return "dashboard";
  }

  @RequestMapping(value = "/addschool", method = RequestMethod.GET)
  public String loadAddSchol(@RequestParam(value = "id", required = false) String schoolID,
      Model model) {
    model.addAttribute("allschool", register.getAllSchool(null));
    model.addAttribute("registration", new School());
    return "user-registration";
  }

  @RequestMapping(value = "/addschool", method = RequestMethod.POST)
  public String addSchool(@ModelAttribute School registration, Model model) {
    register.addschool(registration);
    return "dashboard";
  }

  @RequestMapping(value = "/addwork", method = RequestMethod.GET)
  public String loadAddWork(@RequestParam(value = "id", required = false) String workID,
      Model model) {
    model.addAttribute("allwork", register.getAllWorksites());
    model.addAttribute("registration", new Worksite());
    return "user-registration";
  }

  @RequestMapping(value = "/addwork", method = RequestMethod.POST)
  public String addWork(@ModelAttribute Worksite registration, Model model) {
    register.addwork(registration);
    return "dashboard";
  }
}
