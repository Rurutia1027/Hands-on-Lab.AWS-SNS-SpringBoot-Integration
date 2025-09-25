# Hands-On Lab: AWS SNS + SpringBoot Integration 

## Overview 
This lab demostrates how to integrate AWS Simple Notification Service (SNS) with a Spring Boot application using a custom Spring Boot starter. The goal is to provide a hands-on experience of publishing and consuming messages through SNS in a simplified environment, similar to how a starter integrates with Spring Boot components. 

We focus on: 
- Setting up AWS resources using **Terraform**, somewhat like how **docker-compose** defines and runs local containerized services -- both use configuration files to describe desired state. 
- Configuring a Spring Boot application to send and receive SNS messages using a starter module via Spring Auto-Configure and annotation. 
- Verifying the end-to-end messaging flow without extra infrastructure like Cloud Thread. 

## Architecture
### AWS Infrastructure (Provisioned via Terraform)
- SNS Topic: Central hub for publishing messages. 
- Optional supporting resources (IAM roles/policies) to allow Spring Boot apps to interact with SNS securely. 

Terraform ensures repeatable, version-controlled AWS setup, akin to how docker-compose orchestrates containers locally. 

### Spring Boot Application 
- Sender Module: Publishes message to the SNS topic. 
- Receiver Module: Subscribes to the SNS topic to consume messages. 
- Both modules are configured via a **Spring Boot starter**, which abstracts SNS client initialization, message serialization, and listener registration. 

### Message Flow Verification 
- Send a message from the sender module.
- Receive it in the subscriber module.
- Confirm the message payload and metadata, ensuring full SNS functionality. 


## Features Demostrated 
- Spring Boot starter abstraction for AWS SNS integration.
- Terraform-managed AWS resources: easy provisioning and teardown. 
- Publish/Subscribe messaging pattern: validate end-to-end message delivery. 
- Integration without additional threading or scheduling infrastructure. 

## Notes on SNS and SQS Usage 
- **SNS(Simple Notification Service)**: Pub/Sub messaging; messages sent to topics are delivered to all subscribers. 
- **SQS(Simple Queue Service)**: Queue-based messaging; messages are stored until consumed.


### When to use together
- Often SNS + SQS is combined to implement fan-out patterns reliably. 
- SNS publishes to an SQS queue, and multiple consumers can process messages asynchronously.
- In this lab, we focus on **direct SNS Pub/Sub**; combining with SQS is optional for more advanced use cases. 

## How to Use 
- Provide AWS resources via Terraform
- Start the Spring Boot application
- Use the starter to **send messages** to the SNS topic
- Verify that **subscriber receives messages** successfully

