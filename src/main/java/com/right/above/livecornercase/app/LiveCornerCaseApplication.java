package com.right.above.livecornercase.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.right.above.livecornercase.repository.*")
@ComponentScan("com.right.above.livecornercase.*")
public class LiveCornerCaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiveCornerCaseApplication.class, args);
    }
}
