import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.annotation.Target;
import java.util.*;

public class test {

    private static class T {}

    record Person(String name, String email, int age) {
        public Person (String name) {
            this(name, "", 0);
        }

        private Person(String name, String email) {
            this(name, email, 0);
        }

        public Person (String name, int age) {
            this(name, "", age);
        }

        public static Person of(String name) {
            return new Person(name, "",0);
        }
    }

    private static class A {
        private static final int a = print();

        static int print() {
            System.out.println("static");
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("start main");
    }
}
