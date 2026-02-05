package Exercises.dsaProblems.Strings;

public class SpreadSheetProblem {
    public static void main(String[] args) {
        String formula = "=A1+6";
        formula = formula.substring(1);
        formula = formula.replace("=","");
        String[] s = formula.split("\\+");
        char[] c1 = s[0].toCharArray();
        char[] c2 = s[1].toCharArray();

        int i =0, j = 0,intA1 = 0,intA2 = 0;
        String a1 = "", a2 = "";
        if(Character.isDigit(c1[0])){
            while(i<c1.length){
                a1+=c1[i];
                i++;
            }
            intA1 = Integer.parseInt(a1);
        }
        else{
            int col = c1[0] - 'A';
            i = 1;
            while(i<c1.length){
                a1+=c1[i];
                i++;
            }
//            intA1 = ss[Integer.parseInt(a1)][col];
        }

        // for c2
        if(Character.isDigit(c2[0])){
            i = 0;
            while(i<c2.length){
                a2+=c2[i];
                i++;
            }
            intA2 = Integer.parseInt(a2);
        }
        else{
            int col = c2[0] - 'A';
            i = 1;
            while(i<c2.length){
                a2+=c2[i];
                i++;
            }
//            intA2 = ss[Integer.parseInt(a2)][col];
        }
        System.out.println(intA1+" "+intA2);
    }

}
