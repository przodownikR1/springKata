package pl.java.scalatech.test.profile;

import static org.junit.Assert.assertEquals;
import lombok.extern.slf4j.Slf4j;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.domain.User;
import pl.java.scalatech.profile.FirstConf;
import pl.java.scalatech.profile.SecondConf;

import com.google.common.base.Joiner;

/**
 * @author przodownik
 *         Module name : springKata
 *         Creating time : 26 maj 2014
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { FirstConf.class, SecondConf.class })
public class ProfileTest {
    private AnnotationConfigApplicationContext ctx;

    @Before
    public void init() {
        ctx = new AnnotationConfigApplicationContext();
        // System.setProperty("spring.profiles.active", "first");
        StringBuilder stringBuilder = new StringBuilder();
        Joiner joiner = Joiner.on(",");
        joiner.appendTo(stringBuilder, ctx.getBeanDefinitionNames());
        log.info("+++   init beans : {} ",stringBuilder.toString());

    }

    @Test
    public void shouldFirstProfileLoad() {
        setActiveProfile("first");
        User user = ctx.getBean("getUser", User.class);
        String login = user.getLogin();
        assertEquals("przodownik", login);
    }

    private void setActiveProfile(String name) {
        ctx.getEnvironment().setActiveProfiles(name);
        ctx.register(FirstConf.class, SecondConf.class);
        ctx.refresh();
    }

    @Test
    public void shouldSecondProfileLoad() {
        setActiveProfile("second");
        User user = ctx.getBean("getUser", User.class);
        String login = user.getLogin();
        assertEquals("przodownikB", login);
    }
}
