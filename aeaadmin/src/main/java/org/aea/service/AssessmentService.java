package org.aea.service;

/**
 * Created by sathsrinivasan on 11/29/2015.
 */

import org.aea.dto.*;
import org.aea.entity.Assessment;
import org.aea.entity.Family;
import org.aea.entity.Person;
import org.aea.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
            }

            assessmentRepository.save(assessmentEntity);
        }
        if (familyHead != null) {
//            personRepo.findOne(familyHead.)
            Person head = registrationService.buildUserEntity(familyHead);
            head = personRepo.save(head);

            if (head != null) {
                org.aea.entity.Address addr = new org.aea.entity.Address();
                Address address = assessment.getAddress();
                if (address != null) {
                    addr.setCity(address.getBlock());
                    addr.setDistrict(address.getDistrict());
                    addr.setFline(address.getGp());
                    addr.setRegion(address.getVillage());
                    addr.setState(address.getState());
                    addr.setZip(address.getPin());
                    addr = addrRepo.save(addr);
                }
                org.aea.entity.Worksite work = new org.aea.entity.Worksite();
                int wk = assessment.getWork();
                work = workRepo.findOne(wk);
                Family f = new Family();
                f.setAddress1(addr);
                f.setAddress2(addr);
                f.setCategory(assessment.getCategory());
                f.setFamilyId(registrationService.generateID(head));
                f.setPerson(head);
                f.setWorksiteBean(work);
                f.setRegistration(new Date());

                f = familyRepo.save(f);
                head.setFamilyID(f.getId());
                personRepo.save(head);
                if (!assessment.getFamily().isEmpty()) {
                    for (User usr : assessment.getFamily()) {
                        Person person = registrationService.buildUserEntity(usr);
                        if (person != null) {
                            if (usr.getRelation().equalsIgnoreCase("WIFE")) {
                                person.setPregnencay(usr.getIsPregrant());
                                // if(usr.getExpectedDelivery() != null){
                                // person.set
                                // }
                            } else {

                            }
                            person.setFamilyID(f.getId());
                            person = personRepo.save(person);
                        }
                    }
                }
            }
        }

    }
}
