package com.kevin;

import java.util.List;

@Annotation(value = 0)
@Annotation(1)
public class AnnotationsExample {

    @Annotation(value = 0)
    private int num;

    @Annotation(value = 0)
    public AnnotationsExample() {

    }

    @Annotation(value = 0)
    @Deprecated
    public void setNum(@Annotation(value = 0) int num) {
        this.num = num;
    }

    @Annotation(value = 0)
    @SuppressWarnings("unused")
    public int getNum() {
        return num;
    }

    @Annotation(value = 0)
    public static void main(String[] args) {

        @Annotation(value = 0) AnnotationsExample test = new AnnotationsExample();

        System.out.println(test.num);

    }
}

class AnnotationsExampleSubClass extends AnnotationsExample {

    @Override
    public int getNum() {
        return super.getNum();
    }

    @SafeVarargs
    public final void beSafe(List<Integer>... safety) {

    }
}
