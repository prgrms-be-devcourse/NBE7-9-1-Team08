package org.example.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CafeApplication {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
        SpringApplication.run(CafeApplication.class, args);
    }

}
