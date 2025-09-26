package com.aston.handson.aws.sns.example;

import com.aston.handson.aws.sns.base.enable.EnableSNSStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSNSStarter
@SpringBootApplication
public class AwsSnsSubscriberApplication {
    public static void main(String[] args) {
        SpringApplication.run(AwsSnsSubscriberApplication.class);
    }
}