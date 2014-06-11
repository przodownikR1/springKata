package pl.java.scalatech.jms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author przodownik
 *         Module name : jmsSpringKata
 *         Creating time : 10:29:41 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@ActiveProfiles(value = "normal")
public class BootstrapDaoTest {

    @Test
    public void contextTest() {
        Assert.assertTrue(true);
    }
}
