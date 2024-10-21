package org.jpa_study;

import org.jpa_study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaStudyApplication implements CommandLineRunner {

    @Autowired
    MemberService memberService;

    public static void main(String[] args) {
        SpringApplication.run(JpaStudyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        memberService.insertMember();
    }
}

