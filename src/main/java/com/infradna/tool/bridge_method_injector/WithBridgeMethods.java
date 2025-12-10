package com.infradna.tool.bridge_method_injector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Compatibility stub of the WithBridgeMethods annotation to avoid the external dependency.
 * This annotation does not trigger bridge method generation.
 * <p>
 * Elements mirror the original annotation:
 * <ul>
 *   <li>{@code value} — target bridge return types.</li>
 *   <li>{@code adapterMethod} — optional adapter method name.</li>
 *   <li>{@code castRequired} — whether bridge generation would have required casting.</li>
 * </ul>
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface WithBridgeMethods {
    Class<?>[] value();

    String adapterMethod() default "";

    boolean castRequired() default false;
}
