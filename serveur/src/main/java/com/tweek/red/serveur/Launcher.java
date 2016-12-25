package com.tweek.red.serveur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by tweek on 16/12/16.
 */
@SpringBootApplication
@ComponentScan("com.tweek.red")
@EnableJpaRepositories(basePackages = "com.tweek.red.dao")
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}
