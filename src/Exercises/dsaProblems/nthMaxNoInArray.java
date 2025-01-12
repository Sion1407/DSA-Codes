package Exercises.dsaProblems;
class Sing{
    private static Sing instance;
    private Sing() throws IllegalAccessException {
        if (instance!=null){
            throw new IllegalAccessException("Instance is already created");
        }
    }

    public static synchronized Sing getInstance() throws IllegalAccessException {
        if (instance==null){
            instance = new Sing();
        }
        return instance;
    }
    public void getMssg(){
        System.out.println(instance);
    }

}
public class nthMaxNoInArray {
    public static void main(String[] args) throws IllegalAccessException {
//        int n = 3,max = 0;
//        int[] a = new int[]{2,3,1,5,4,6,9};
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//    //    5
//        for(int x: a){
//            pq.add(x);
//            if (pq.size()>n){
//                pq.poll();
//            }
//        }
//        System.out.println(pq.peek());
        Sing sing = Sing.getInstance();
        sing.getMssg();
        Sing sing1 = Sing.getInstance();
        sing1.getMssg();
        System.out.println(factorial(4));
    }

    private static int factorial(int n){
        if (n==1)
            return 1;
        return n* factorial(n-1);
    }
}
