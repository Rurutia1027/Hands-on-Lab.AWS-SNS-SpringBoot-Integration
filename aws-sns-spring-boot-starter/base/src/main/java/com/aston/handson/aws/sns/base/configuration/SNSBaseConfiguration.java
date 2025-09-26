package com.aston.handson.aws.sns.base.configuration;

import com.aston.handson.aws.sns.base.enable.MarkerConfiguration;
import com.aston.handson.aws.sns.base.loader.SpringPropertiesLoader;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class SNSBaseConfiguration {
    @Bean
    public SpringPropertiesLoader springPropertiesLoader() {
        return new SpringPropertiesLoader();
    }
}