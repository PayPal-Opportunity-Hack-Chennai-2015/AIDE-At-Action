/**
 * 
 */
package org.aea.service;

import java.util.List;

import org.aea.dto.FamilyRegistration;
import org.aea.dto.School;
import org.aea.dto.Worksite;
import org.springframework.stereotype.Service;

/**
 * @author Prasad
 *
 */
@Service
public class RegistrationService {

  
  /**
   * @return
   */
  public List<Worksite> getAllWorksites(){
    return null;
  }
  
  /**
   * @param region
   * @return
   */
  public List<School> getAllSchool(String region){
    
    return null;
  }

  /**
   * @param registration
   */
  public void save(FamilyRegistration registration) {

  }

  public void addschool(org.aea.entity.School registration) {
    // TODO Auto-generated method stub
    
  }

  public void addwork(Worksite registration) {
    // TODO Auto-generated method stub
    
  }
}
