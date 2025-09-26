package com.aston.handson.aws.sns.example.controller;

import com.aston.handson.aws.sns.core.service.SNSClientService;
import com.aston.handson.aws.sns.starter.properties.SNSProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SnsPublishController {
    private final SNSClientService snsClientService;
    private final SNSProperties snsProperties;

    @PostMapping("/publish")
    public String publish(@RequestParam String message) {
        return snsClientService.publish(snsProperties.getTopicArn(), message);
    }
}