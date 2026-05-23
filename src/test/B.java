package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class B {

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.FIELD)
    private @interface Abc {
        String name();
    }

    @Abc(name = "asd")
    static final int Z = 123;
    static int A = print();
    private final int Cc = 1;

    static {
        hello();
    }

    static int print() {
        System.out.println("static field");
        C day = C.DAY;

        return 1;
    }

    static void hello() {
        System.out.println("static static");
    }
}
