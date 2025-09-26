package com.aston.handson.aws.sns.example.controller;

import com.aston.handson.aws.sns.core.service.SNSClientService;
import com.aston.handson.aws.sns.starter.properties.SNSProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sns")
public class SNSSubscriberController {

    private final SNSClientService snsClientService;
    private final SNSProperties snsProperties;
    private static final Logger logger = LoggerFactory.getLogger(SNSSubscriberController.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    /** Trigger HTTP subscription */
    @GetMapping("/subscribe")
    public String subscribeHttp() {
        String subscriptionArn = snsClientService.subscribe(
                snsProperties.getTopicArn(),
                "email",
                "rurutia1027@gmail.com"
        );
        return "HTTP Subscription ARN: " + subscriptionArn;
    }

    /** Check if SNS client is available */
    @GetMapping("/available")
    public boolean isSNSClientAvailable() {
        return snsClientService.isSNSClientAvailable();
    }

    /** List all subscriptions for the topic */
    @GetMapping("/subscriptions")
    public List<String> getSubscriptions() {
        return snsClientService.listSubscriptions(snsProperties.getTopicArn());
    }
}