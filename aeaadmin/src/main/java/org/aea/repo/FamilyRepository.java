package org.aea.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.aea.entity.Family;

public interface FamilyRepository extends JpaRepository<Family, String> {
	
    @Query("SELECT f FROM Family f")
    List<Family> getFamilyList();
}
