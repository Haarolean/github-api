package com.infradna.tool.bridge_method_injector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Minimal local copy of the WithBridgeMethods annotation to avoid the external dependency.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WithBridgeMethods {
    Class<?>[] value();

    String adapterMethod() default "";

    boolean castRequired() default false;
}
