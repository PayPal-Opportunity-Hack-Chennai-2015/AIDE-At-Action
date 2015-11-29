package org.aea.repo;

import java.util.List;

import org.aea.entity.Worksite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface GetWorkSitesWithTypeByCity extends JpaRepository<Worksite,Integer>{
	
	//public final static String GET_ALL_WORKSITES_BY_CITY_QUERY = "select count(*), worksite.name,  worksite.type,  address.city from  worksite join  address on  worksite.address= address.id group by  address.city, worksite.type;";
	
	/**
     * Find worksites by type.
     */
	/*
    @Query(GET_ALL_WORKSITES_BY_CITY_QUERY)
    public List<Worksite> findByType();
	*/
}
