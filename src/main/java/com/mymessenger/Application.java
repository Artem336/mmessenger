package com.mymessenger;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static final Logger log = Logger.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        log.info("Start Application");
    }
}
