package org.aea;

import org.aea.dto.AssessmentDetails;
import org.aea.service.AssessmentService;
import org.aea.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sathsrinivasan on 11/29/2015.
 */
@Controller
public class AssessmentController {

    @Autowired
    private RegistrationService register;

    @Autowired
    private AssessmentService assessmentService;

    @RequestMapping(value = "/assess", method = RequestMethod.GET)
    public String loadAssessment(@RequestParam(value = "id", required = false) String familyID,
                                 Model model) {
        final AssessmentDetails assessmentDetails = assessmentService.getAssessmentDetails(familyID);
        model.addAttribute("allschool", register.getAllSchool(null));
        model.addAttribute("allwork", register.getAllWorksites());
        model.addAttribute("allngos", register.getAllNgos());

        model.addAttribute("assessment", assessmentDetails);
        return "assessment";
    }

    @RequestMapping(value = "/assess", method = RequestMethod.POST)
    public String saveAssessment(@ModelAttribute AssessmentDetails assessment,
                                 Model model) {
//        final AssessmentDetails assessmentDetails = assessmentService.getAssessmentDetails(familyID);
//        model.addAttribute("allschool", register.getAllSchool(null));
//        model.addAttribute("allwork", register.getAllWorksites());
//        model.addAttribute("allngos", register.getAllNgos());
//
//        model.addAttribute("assessment", assessmentDetails);
        assessmentService.save(assessment);

        return "assessment";
    }

}
