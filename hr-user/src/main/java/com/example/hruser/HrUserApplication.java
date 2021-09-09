package com.example.hruser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {

    private final BCryptPasswordEncoder passwordEncoder;

    public HrUserApplication(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(HrUserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //cria hash
        //System.out.println(passwordEncoder.encode("BCRYPT =" + "123456"));
    }
}
