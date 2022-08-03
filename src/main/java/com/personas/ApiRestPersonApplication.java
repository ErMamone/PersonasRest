package com.personas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@AutoConfigurationPackage
public class ApiRestPersonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiRestPersonApplication.class, args);
    }
}
