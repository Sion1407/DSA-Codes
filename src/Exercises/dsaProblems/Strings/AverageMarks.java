package Exercises.dsaProblems.Strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
class Test{
    public float marks;
    public int subCount;
    Test(float marks, int subCount){
        this.marks = marks;
        this.subCount = subCount;
    }

}
public class AverageMarks {
    public static void main(String[] args) {
        System.out.println(averageMarks(new String[][]{{"jerry","65"},{"bob","91"}, {"jerry","23"}, {"Eric","83"},{"bob", "10"}}));
    }
    public static Float averageMarks(String[][] students){
        Map<String, Test> hm = new HashMap<>();
        for (String[] s : students){
            if (hm.containsKey(s[0])){
                Test t1 = hm.get(s[0]);
                float currSum = t1.marks+Integer.parseInt(s[1]);
                t1.subCount++;
                t1.marks = currSum/ t1.subCount;
                hm.put(s[0],new Test(t1.marks, t1.subCount));
            }
            else{
                hm.put(s[0],new Test(Integer.parseInt(s[1]),1));
            }
        }
        float avg = hm.entrySet().stream().max(Comparator.comparingDouble(e->e.getValue().marks)).get().getValue().marks;
        return avg;
    }
}
