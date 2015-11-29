package org.aea;

import org.aea.service.ReportingService;
import org.aea.dto.Worksite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReportController {
  
  @Autowired
  public ReportingService reportService;
    
  @RequestMapping(value = "/getwork", method= RequestMethod.GET)
  public String loadAddWork(@RequestParam(value = "id", required = false) String workID,
      Model model) {
    model.addAttribute("allwork", reportService.getAllWorksites());
    model.addAttribute("registration", new Worksite());
    return "user-registration";
  }
      
  @RequestMapping("/report")
  public String getReport(Model model) {
      return "report";
  }
  
}
