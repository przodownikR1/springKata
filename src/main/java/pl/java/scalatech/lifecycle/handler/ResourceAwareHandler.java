package pl.java.scalatech.lifecycle.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourceAwareHandler implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;
   
    
    public void showFileContent() throws IOException {
        Resource banner = resourceLoader.getResource("classpath:text.txt");
        try (InputStream in = banner.getInputStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
        }
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}