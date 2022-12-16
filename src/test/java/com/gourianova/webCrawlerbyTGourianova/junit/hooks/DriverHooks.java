package com.gourianova.webCrawlerbyTGourianova.junit.hooks;

import org.apiguardian.api.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class DriverHooks {
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    @API(
            status = API.Status.STABLE
    )
    public @interface After{
        String value() default "";
        int order() default 10000;
    }
}
