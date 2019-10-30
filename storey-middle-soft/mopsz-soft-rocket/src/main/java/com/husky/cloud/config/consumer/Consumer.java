package com.husky.cloud.config.consumer;

import org.springframework.stereotype.Component;
import java.lang.annotation.*;

@Component
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Consumer {

    String group() default "";
    String topic() default "";
    String tag() default "";

}
