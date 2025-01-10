package Exercises.dsaProblems;

import java.util.Scanner;

public class PowerOfTow {
    public static String PowersofTwo(String num) {

        int n = Integer.parseInt(num);
        while(n!=1){
            if (n%2!=0)
                return "false";
            n = n/2;
        }
        return "true";
    }
    public static String SnakeCase(String str) {
        // code goes here
        String res = "";
        for(int i = 0 ;i< str.length();i++){
            if(str.charAt(i) == ' ' || str.charAt(i) == '!' || str.charAt(i) == '@'|| str.charAt(i) == '#'||
                    str.charAt(i) == '$'|| str.charAt(i) == '*'
                    || str.charAt(i) == '&' || str.charAt(i) == '-' ){
                res+="_";
            }
            else{
                res+=Character.toLowerCase(str.charAt(i));
            }

        }
        return res;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
//        System.out.print(PowersofTwo(s.nextLine()));
        System.out.println(SnakeCase("cats AND*Dogs-are Awesome"));
    }
}
