resource "aws_sns_topic" "lab_topic" {
    name = var.sns_topic_name
}

resource "aws_sns_topic_subscription" "lab_subscription" {
    count = var.sns_subscription_email != "" ? 1 : 0
    topic_arn = aws_sns_topic.lab_topic.arn
    protocol = "email"
    endpoint = var.sns_subscription_email
}