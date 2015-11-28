package org.aea;

import org.aea.dto.Login;
import org.aea.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
  
  @Autowired
  public HomeService homeService;
  
  @RequestMapping("/home")
  public String index(Model model) {
      return "index";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String login(@ModelAttribute Login login, Model model) {
      return "dashboard";
  }
  
}
