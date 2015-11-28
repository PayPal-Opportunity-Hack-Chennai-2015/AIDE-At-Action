package org.aea;

import org.aea.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  
  @Autowired
  public HomeService homeService;
  
  @RequestMapping("/home")
  public String index(Model model) {
      return "user-registration";
  }
  
}
