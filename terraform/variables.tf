variable "sns_topic_name" {
    description = "Name of the SNS topic"
    type = string 
    default = "sns-spring-boot-lab-topic"
}

variable "sns_subscription_email" {
    description = "Optional email subscription for testing"
    type = string 
    default = ""
}
