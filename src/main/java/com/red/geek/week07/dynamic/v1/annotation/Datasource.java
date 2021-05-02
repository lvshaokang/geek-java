package com.red.geek.week07.dynamic.v1.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Datasource
 *
 * @author red
 * @class_name Datasource
 * @date 2021-05-02
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Datasource {
}
