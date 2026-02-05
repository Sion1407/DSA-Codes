package DesignPattern;

public class Doubleton {
    private static Doubleton instance1;
    private static Doubleton instance2;
    private static int counter = 0;

    private Doubleton() {}

    public static synchronized Doubleton getInstance() {
        counter++;
        if (counter % 2 == 1) {
            if (instance1 == null) {
                instance1 = new Doubleton();
            }
            return instance1;
        } else {
            if (instance2 == null) {
                instance2 = new Doubleton();
            }
            return instance2;
        }
    }
}
