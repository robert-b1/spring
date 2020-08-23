package test.demo.spring.core.person;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class PersonTest extends TestCase {

    @Autowired
    private Backpack backpack;

    @Autowired
    private Backpack backpack2;

    @Autowired
    private Backpack backpack3;

    @Test
    public void testBackpack(){
        log.info("Hashcode of backpack object is {}", backpack.hashCode());
        log.warn("Hashcode of backpack2 object is {}", backpack2.hashCode());
        log.error("Hashcode of backpack3 object is {}", backpack3.hashCode());
    }
}