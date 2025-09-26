package com.aston.handson.aws.sns.base.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MarkerConfiguration.class)
@Documented
public @interface EnableSNSStarter {
}