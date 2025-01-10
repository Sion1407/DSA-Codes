package Exercises.dsaProblems;

public class SingletonClass {
    private static SingletonClass instance;

    private SingletonClass(){
        if (instance!=null)
            throw new IllegalStateException("instance already created");
    }

    public static synchronized SingletonClass getInstance(){
        if (instance==null)
            instance = new SingletonClass();
        return instance;
    }
    public void showMessage() {
        System.out.println("Singleton instance says hello!");
    }

    public static void main(String[] args) {
        SingletonClass singletonClass = SingletonClass.getInstance();
        singletonClass.showMessage();
        SingletonClass singletonClass1 = SingletonClass.getInstance();
        singletonClass1.showMessage();
    }

}
