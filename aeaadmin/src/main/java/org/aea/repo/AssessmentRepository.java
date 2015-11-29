package org.aea.repo;

import org.aea.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sathsrinivasan on 11/28/2015.
 */
public interface AssessmentRepository extends JpaRepository<Assessment,Integer>{
}
