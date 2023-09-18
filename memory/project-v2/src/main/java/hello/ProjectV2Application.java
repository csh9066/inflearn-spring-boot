package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ProjectV2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectV2Application.class, args);
    }
}
