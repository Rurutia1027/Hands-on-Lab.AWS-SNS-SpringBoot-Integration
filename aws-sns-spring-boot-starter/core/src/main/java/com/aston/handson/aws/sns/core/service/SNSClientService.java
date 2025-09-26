package com.aston.handson.aws.sns.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.*;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SNSClientService {
    private final SnsClient snsClient;

    public boolean isSNSClientAvailable() {
        return Objects.nonNull(snsClient) && Objects.nonNull(snsClient.listTopics());
    }

    /** Publish message to SNS Topic */
    public String publish(String topicArn, String message) {
        PublishResponse response = snsClient.publish(
                PublishRequest.builder()
                        .topicArn(topicArn)
                        .message(message)
                        .build()
        );
        return response.messageId();
    }

    /** Create subscription (email, SMS, SQS, etc.) */
    public String subscribe(String topicArn, String protocol, String endpoint) {
        SubscribeResponse response = snsClient.subscribe(
                SubscribeRequest.builder()
                        .topicArn(topicArn)
                        .protocol(protocol)
                        .endpoint(endpoint)
                        .build()
        );
        return response.subscriptionArn();
    }

    /** List subscriptions */
    public void listSubscriptions(String topicArn) {
        snsClient.listSubscriptionsByTopic(
                ListSubscriptionsByTopicRequest.builder()
                        .topicArn(topicArn)
                        .build()
        ).subscriptions().forEach(sub -> {
            System.out.println("Subscription: " + sub.endpoint());
        });
    }
}