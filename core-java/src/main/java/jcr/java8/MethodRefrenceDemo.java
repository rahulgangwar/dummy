package jcr.java8;

/** Created by rahul on 25/11/17. */
public class MethodRefrenceDemo {
    public static void main(String[] args) {
        refToStaticMethod();
    }

    static class Myclass {
        public Myclass(int i) {
            System.out.println("Inside constructor : " + i);
        }

        public static void myMethod(int i) {
            System.out.println("Inside my method : " + i);
        }

        public void mySecondMethod(int i) {
            System.out.println("Inside mySecondMethod : " + i);
        }
    }

    interface Sayable {
        void say(int i);
    }

    // type 1: Reference to a static method.
    public static void refToStaticMethod() {
        Sayable sayable = Myclass::myMethod;
        sayable.say(1);
    }

    // type 2: Reference to an Instance Method
    public static void refToInstanceMethod() {
        Sayable sayable = new Myclass(1)::mySecondMethod;
        sayable.say(1);
    }

    // type 3: Reference to a Constructor
    public static void refToConstructor() {
        Sayable sayable = Myclass::new;
        sayable.say(1);
    }
}
