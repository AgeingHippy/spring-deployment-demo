package co.codingnomads.deployment;

import co.codingnomads.deployment.models.Hello;
import co.codingnomads.deployment.repositories.HelloRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringDeploymentDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringDeploymentDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(HelloRepository helloRepository) {
        return (args) -> {
            log.info("*************** TESTING LOG OUTPUT ***************");
            if (helloRepository.findAll().isEmpty()) {
                helloRepository.save(new Hello("CodingNomads"));
            }
        };
    }
}