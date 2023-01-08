package org.wahlzeit;

public @interface PatternInstance {

    public String patternName() default "";
    public String[] participants() default {};
}
