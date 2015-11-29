package org.aea.service;

/**
 * Created by sathsrinivasan on 11/29/2015.
 */

import org.aea.dto.*;
import org.aea.dto.Address;
import org.aea.entity.*;
import org.aea.entity.School;
import org.aea.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private FamilyRepository familyRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private AddressRepo addrRepo;

    @Autowired
    private WorksiteRepository workRepo;

    @Autowired
    private SchoolRepo schoolRepo;

    public AssessmentDetails getAssessmentDetails(String familyID) {
        final AssessmentDetails reg = new AssessmentDetails();
        List<Family> families = familyRepo.findByFamilyId(familyID);
        if (families != null && !families.isEmpty()) {
            Family family = families.get(0);
            reg.setFamilyId(familyID);
            // Person head = family.getPerson();
            // User headUser = buildUser(head);
            // if(headUser != null){
            // reg.setFamilyHead(headUser);
            org.aea.entity.Address addressE = family.getAddress1();
            Address primaryAddr = AeaUtils.buildAddrModel(addressE);
            reg.setAddress(primaryAddr);
            reg.setCategory(family.getCategory());
            org.aea.entity.Worksite work = family.getWorksiteBean();
            if (work != null) {
                reg.setWork(work.getId());
                reg.setWorkName(work.getName());
            }
            List<Person> persons = personRepo.findByFamilyID(family.getId());
            if (persons != null && !persons.isEmpty()) {
                for (Person person : persons) {
                    User user = AeaUtils.buildUser(person);
                    if (user.getRelation() != null) {
                        reg.setFamilyHead(user);
                    } else {
                        reg.getFamily().add(user);
                    }
                }
            }
        }

        return reg;
    }

    public void save(AssessmentDetails assessment) {
        User familyHead = assessment.getFamilyHead();
        final String familyId = assessment.getFamilyId();
        final List<Family> families = familyRepo.findByFamilyId(familyId);
        if (families != null && !families.isEmpty()) {
            final Family family = families.get(0);
            final Assessment assessmentEntity = new Assessment();
            assessmentEntity.setAssessDate(new Date());
            assessmentEntity.setFamilyBean(family);
            assessmentEntity.setWorksiteBean(family.getWorksiteBean());
            final FamilyEntitlement familyEntitlement = assessment.getFamilyEntitlement();
            if (familyEntitlement != null) {
                assessmentEntity.setMarriageScheme(familyEntitlement.getIsMarriageScheme());
                assessmentEntity.setMeternalBenifits(familyEntitlement.getIsMarriageBenefits());
//                assessmentEntity.setNotes(familyEntitlement.get);
                assessmentEntity.setNgo(family.getPrinaryNgo());
                assessmentEntity.setOldagePesion(familyEntitlement.getIsOldAgePension());
                assessmentEntity.setWidowPension(familyEntitlement.getIsWidowPension());
                assessmentEntity.setRation(familyEntitlement.getRation());
            }
            for (User user : assessment.getFamily()) {
                //TODO have to set assessment health
                final NutritionAssessment nutritionAssessment = user.getNutritionAssessment();
                if (nutritionAssessment != null) {
                    assessmentEntity.setAssessmentHealths(new HashSet<AssessmentHealth>());
                    final AssessmentHealth assessmentHealth = new AssessmentHealth();
                    assessmentHealth.setAnemic(nutritionAssessment.getIsAnemic());
                    assessmentHealth.setCleanwater(nutritionAssessment.getIsCleanWater());
                    assessmentHealth.setNutrition(nutritionAssessment.getIsNutrition());
                    assessmentHealth.setSanitation(nutritionAssessment.getIsSanitation());
                    assessmentEntity.getAssessmentHealths().add(assessmentHealth);
                }

                final EducationAssessment educationAssessment = user.getEducationAssessment();
                if (educationAssessment != null) {
                    assessmentEntity.setAssessmentEducations(new HashSet<AssessmentEducation>());
                    final AssessmentEducation assessmentEducation = new AssessmentEducation();
                    assessmentEducation.setBooks(educationAssessment.getIsBooks());
                    assessmentEducation.setScholarship(educationAssessment.getIsScholarship());
                    assessmentEducation.setGrade(educationAssessment.getGrade());
                    final int selectedSchool = educationAssessment.getSelectedSchool();
                    final School school = schoolRepo.findOne(selectedSchool);
                    if (school != null) {
                        assessmentEducation.setSchoolBean(school);
                    }
                    assessmentEntity.getAssessmentEducations().add(assessmentEducation);
                }
            }
            assessmentRepository.save(assessmentEntity);
        }

    }
}
