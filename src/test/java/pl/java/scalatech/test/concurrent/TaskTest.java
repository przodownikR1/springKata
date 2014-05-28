package pl.java.scalatech.test.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.concurrent.AgileBean;
import pl.java.scalatech.concurrent.TaskConf;

import com.google.common.base.Stopwatch;

/**
 * @author przodownik
 *         Module name : springKata
 *         Creating time : 28 maj 2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TaskConf.class })
@Slf4j
public class TaskTest {
    @Autowired
    private ExecutorService cachedThreadPoolExecutorService;

    @Test
    public void shouldCacheThreadExecutorWork() {
        AgileBean task = new AgileBean("cachedPool");
        task.run();
        Stopwatch timer = Stopwatch.createStarted();
        try {

            task.setName("przodownik -  < work");
            if (cachedThreadPoolExecutorService.submit(task) == null) {
                log.info("###                      task during : {} ms ", timer.elapsed(TimeUnit.MILLISECONDS));
            }

        } catch (RuntimeException re) {
            log.error("", re);

        }

    }

}
