package org.aea.service;

import org.aea.dto.Address;
import org.aea.dto.EducationAssessment;
import org.aea.dto.NutritionAssessment;
import org.aea.dto.User;
import org.aea.entity.Person;

/**
 * Created by sathsrinivasan on 11/29/2015.
 */
public final class AeaUtils {

    public static Address buildAddrModel(org.aea.entity.Address addressE) {
        Address addr = new Address();
        if (addressE != null) {
            addr.setBlock(addressE.getCity());
            addr.setDistrict(addressE.getDistrict());
            addr.setGp(addressE.getFline());
            addr.setVillage(addressE.getRegion());
            addr.setState(addressE.getState());
            addr.setPin(addressE.getZip());
        }

        return addr;
    }

    public static User buildUser(Person person) {
        User user = new User();
        if (person != null) {
            user.setAge(person.getAge());
            user.setGender(person.getGender());
            user.setName(person.getFname());
            user.setIsPregrant(person.getPregnencay());
            user.setRelation(person.getTitle());

            //Setting default values for assesment objects
            user.setNutritionAssessment(new NutritionAssessment());
            user.setEducationAssessment(new EducationAssessment());
            return user;
        }
        return user;
    }
}
