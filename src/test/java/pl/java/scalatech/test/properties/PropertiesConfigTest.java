package pl.java.scalatech.test.properties;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.properties.PropConfig;

/**
 * @author przodownik
 *         Module name : springKata
 *         Creating time : 28 maj 2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PropConfig.class })
@Slf4j
public class PropertiesConfigTest {

    @Value("${login}")
    private String login;

    @Value("${login2:przodownikR2}")
    private String loginDefault;

    @Autowired
    private Environment env;

    @Test
    public void shouldPropertiesLoad() {
        Assertions.assertThat(true);
        // then
        Assertions.assertThat(login).isNotEmpty().isEqualTo("przodownikR1");
    }

    @Test
    public void shouldSpelDefaultWorks() {
        // then
        Assertions.assertThat(loginDefault).isNotEmpty().isEqualTo("przodownikR2");
    }

    @Test
    public void shouldEnvLoad() {
        Assertions.assertThat(env.getProperty("user.home")).isNotEmpty();
        log.info("++++    userHome = > {}", env.getProperty("user.home"));
    }
}
