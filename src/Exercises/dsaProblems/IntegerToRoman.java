package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(13));
    }

    public static String intToRoman(int num){
        String res = "";
        int [] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String [] roman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        for (int i = values.length-1;i>=0 && num>0; i--){
            while (num>=values[i]){
                num-=values[i];
                res+=roman[i];
            }
        }
        System.out.println(2147483648.0>Math.pow(2,31));
        return res;
    }
}
