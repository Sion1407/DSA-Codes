package Exercises.dsaProblems;

public class NoOfSeniorCitizens {
    public static void main(String[] args) {
        System.out.println(countSeniors(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}));
    }

    public static int countSeniors(String[] details) {
        char[] d = new char[16];
        // String age = d[11]+ d[12];
        int c = 0;
        for(String s: details){
            d = s.toCharArray();
            String age = String.valueOf(d[11]) + String.valueOf(d[12]);
            if(Integer.valueOf(age) > 60){
                c++;
            }
        }
        return c;
    }
}
