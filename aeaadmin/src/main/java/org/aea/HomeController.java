package org.aea;

import org.aea.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
  
  @Autowired
  public HomeService homeService;

  @RequestMapping("/greeting")
  public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
      model.addAttribute("name", name);
      homeService.test();
      return "greeting";
  }
  
  @RequestMapping("/home")
  public String index(Model model) {
      return "index";
  }
  
}
