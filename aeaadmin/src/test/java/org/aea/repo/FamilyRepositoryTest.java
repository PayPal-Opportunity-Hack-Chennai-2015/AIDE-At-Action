package org.aea.repo;

import org.aea.AeaadminApplication;
import org.aea.repo.FamilyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;

@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
  @RunWith(SpringJUnit4ClassRunner.class)
  @SpringApplicationConfiguration(classes = AeaadminApplication.class)
  @DatabaseSetup(FamilyRepositoryTest.DATASET)
  @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { FamilyRepositoryTest.DATASET })
  @DirtiesContext

public class FamilyRepositoryTest {
	
    protected static final String DATASET = "classpath:datasets/FamilyDS.xml";
    
    @Autowired
    private FamilyRepository repository;
	
    @Test
    public void getFamilyList() {
      
    assert(repository.getFamilyList().size()>0);  
    
    
        
    }

}
