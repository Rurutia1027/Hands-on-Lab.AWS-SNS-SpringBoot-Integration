// com.aston.handson.enable.MarkerConfiguration
package com.aston.handson.aws.sns.base.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarkerConfiguration {

    @Bean
    public Marker snsClientServiceMarkerBean() {
        return new Marker();
    }

    public class Marker { }
}