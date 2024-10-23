package org.jpa_study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaStudyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaStudyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

