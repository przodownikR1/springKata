package pl.java.scalatech.test.profile;

import static org.junit.Assert.assertEquals;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.domain.User;
import pl.java.scalatech.profile.FirstConf;
import pl.java.scalatech.profile.SecondConf;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  26 maj 2014
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { FirstConf.class, SecondConf.class })
@ActiveProfiles(profiles = "first")
public class ProfileActiveTest {
    @Autowired
    private User user;

    @Test
    public void shouldFirstProfileLoad() {

        String login = user.getLogin();
        assertEquals("przodownik", login);
    }
}
