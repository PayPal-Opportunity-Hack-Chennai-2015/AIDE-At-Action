/**
 * 
 */
package org.aea.repo;

import org.aea.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Prasad
 *
 */
public interface SchoolRepo extends JpaRepository<School, Integer> {

  
}
