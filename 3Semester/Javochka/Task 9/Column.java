package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME) // где видна аннотация
@Target(value = ElementType.FIELD) // где используется аннотация
public @interface Column {
}
