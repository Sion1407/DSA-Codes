package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

//3233
public class FindAndCountNoWhichAreNotSpecial {
    public static void main(String[] args) {
        System.out.println(nonSpecialCount(4,16));
    }

    public static int nonSpecialCount(int l, int r) {
        List<Boolean> primenos = new ArrayList<>();
        for (int i = 0; i <= r; i++) {
            primenos.add(true);
        }

        int c = 0;
//        SieveOfEratosthenes gives prime nos. upto n in optimised way
        for (int i = 2; i <= r; i++) {
            if (primenos.get(i)==true){
                for (int j = i*i;j<=r; j+=i){
                    primenos.set(j,false);
                }
            }
        }
        for (int i = 2; i <= r; i++) {
            if (primenos.get(i) == true)
            {
                if ((i*i)>=l && (i*i)<=r){
                    c++;
                }
            }
        }

        return (r-l+1)-c;
    }
}
