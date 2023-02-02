package com.kevin;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD,
        ElementType.METHOD, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.LOCAL_VARIABLE,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
@Documented
@Inherited
public @interface Annotations {

    Annotation[] value();
}
