/**
 * 
 */
package org.aea.repo;

import java.util.List;

import org.aea.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Prasad
 *
 */
public interface PersonRepo extends JpaRepository<Person, Integer> {

  List<Person> findByFamilyID(int id);

}
