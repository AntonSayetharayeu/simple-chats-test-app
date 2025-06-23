package testapp;

public class TestMain {
    public static void main(String[] args) {

    }

    private static String className(String str){
        return str.split("\\$")[1];
    }

    private static class Animal {
        public int id;
    }
    private static class Bear extends Animal {
        public int roar;
    }
    private static class Cat extends Animal {}

    //---------------------------------------------------//

    private interface A {
        default void doSmth() {}
    }
    private interface B {
        default void doSmth() {}
    }

    private static class C implements B, A {
        @Override
        public void doSmth() {

        }
    }
}
