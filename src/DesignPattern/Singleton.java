package DesignPattern;

class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    // private constructor to avoid client applications using the constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}

class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    // static block initialization for exception handling
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

public class Singleton {
    private static Singleton singleton;
    private Singleton(){}
    public synchronized static Singleton getInstance(){
        if (singleton!=null) return singleton;
        singleton = new Singleton();
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
