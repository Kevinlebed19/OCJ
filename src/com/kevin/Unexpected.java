package com.kevin;

import java.lang.annotation.Inherited;

enum Food {
}

@Inherited public @interface Unexpected {
    public String rsvp() default "hi";

    Food food();

    public String[] dessert();

    final int numberOfGuests = 5;

    long startTime() default 0L;
}
