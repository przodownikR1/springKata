package pl.java.scalatech.test.configurator;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.configuration.MyConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfig.class})
@Slf4j
public class MyConfigTest {
  //http://www.intertech.com/Blog/spring-4-conditional-bean-configuration/
    @Autowired 
    private String value;
    @Autowired
    private Environment env;
    @Test
    public void shouldFindBean(){
       if(env.getProperty("user.country").equals("PL")){
        Assertions.assertThat(value).isEqualTo("przodownik");
       }else{
           Assertions.assertThat(value).isEqualTo("foreign");
       }
    }
}
