package com.cgi.devhive.kaffeeplan.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KaffeeplanApplication {
    public static void main(String[] args) {
        SpringApplication.run(KaffeeplanApplication.class, args);
    }
}
