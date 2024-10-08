package Exercises.dsaProblems;
//134
public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int l = 0,count = 0;
//        while (l < gas.length){
//            int total = 0,r = l,stopCnt = 0;
//            while (stopCnt< gas.length){
//                total+=gas[r%gas.length] - cost[r% gas.length];
//                if (total < 0)
//                    break;
//                stopCnt++;
//                r++;
//            }
//            if (stopCnt== gas.length && total >= 0)
//                return l;
//            l++;
//        }
//        return -1;

//        optimal
        int total = 0, tank = 0,idx = 0;
        for (int i = 0; i < gas.length; i++) {
            tank+=gas[i] - cost[i];
            if (tank < 0){
                tank = 0;
                idx = i+1;
            }
            total+=gas[i] - cost[i];
        }
        return total < 0 ? -1 : idx;
    }
}
