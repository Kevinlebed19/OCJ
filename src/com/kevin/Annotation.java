package com.kevin;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD,
        ElementType.METHOD, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.LOCAL_VARIABLE,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
@Documented
@Inherited
@Repeatable(Annotations.class)
public @interface Annotation {

    int value();

    String poolNoodle() default "he" + "yo";
}
