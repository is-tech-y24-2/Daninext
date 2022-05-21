package ru.itmo.kotiki.catsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EntityScan("ru.itmo.kotiki.servicedata")
@ComponentScan("ru.itmo.kotiki")
@EnableJpaRepositories("ru.itmo.kotiki.servicedata")
public class CatsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatsServiceApplication.class, args);
    }

}
