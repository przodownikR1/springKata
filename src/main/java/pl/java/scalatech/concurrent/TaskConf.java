package pl.java.scalatech.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author przodownik
 *         Module name : springKata
 *         Creating time : 28 maj 2014
 */
@Configuration
@EnableAsync
@EnableScheduling
@Import(AgileBean.class)
public class TaskConf {
    @Bean
    public ExecutorService cachedThreadPoolExecutorService() {
        return Executors.newCachedThreadPool();
    }
    
    @Bean
    public ExecutorService fixedThreadPool(){
        return Executors.newFixedThreadPool(100);
    }
    @Bean
    public ExecutorService singleThreadExecutorService(){
        return  Executors.newSingleThreadExecutor();
    }
         
    @Bean    
    public ScheduledExecutorService scheduledThreadExecutorService(){
        return Executors.newScheduledThreadPool(10);
    }
            
    
}
