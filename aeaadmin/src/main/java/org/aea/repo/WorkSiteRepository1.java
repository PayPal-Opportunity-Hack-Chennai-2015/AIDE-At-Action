package org.aea.repo;

import java.util.List;

import org.aea.entity.Worksite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkSiteRepository1 extends JpaRepository<Worksite,Integer>{
	
	public final static String FIND_WORKSITES_BY_TYPE_QUERY = "SELECT w " +  "FROM Worksite w WHERE w.type = :type";
	
	/**
     * Find worksites by type.
     */
    @Query(FIND_WORKSITES_BY_TYPE_QUERY)
    public List<Worksite> findByType(@Param("type") String type);
	
}
