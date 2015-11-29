package org.aea.repo;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.aea.AeaadminApplication;
import org.aea.entity.Worksite;
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

import java.util.List;

/**
 * Created by sathsrinivasan on 11/29/2015.
 */
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AeaadminApplication.class)
@DatabaseSetup(WorksiteRepoTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {WorksiteRepoTest.ADDRESS_DATASET,
        WorksiteRepoTest.DATASET})
@DirtiesContext
public class WorksiteRepoTest {
    protected static final String ADDRESS_DATASET = "classpath:datasets/address.xml";
    protected static final String DATASET = "classpath:datasets/worksites.xml";

    @Autowired
    private WorksiteRepository worksiteRepository;

    @Test
    public void testWorksiteQuering() {
        final List<Worksite> worksites = worksiteRepository.findAll();
        for (Worksite worksite : worksites) {
            System.out.println(worksite);
            System.out.println(worksite.getAddressBean());
        }
    }
}
