package io.github.MatheusFSantos.Kernel.KNUsers.model.annotation;

import io.github.MatheusFSantos.Kernel.KNUsers.model.enumeration.Roles;

import javax.management.relation.Role;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Authorize {
    String role() default "ANY";
    boolean required() default false;
}
