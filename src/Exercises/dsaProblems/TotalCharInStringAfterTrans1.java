package Exercises.dsaProblems;

public class TotalCharInStringAfterTrans1 {
    public static void main(String[] args) {
        System.out.println(lengthAfterTransformations("jqktcurgdvlibczdsvnsg",7517));
    }
    public static int lengthAfterTransformations(String s, int t) {
        int []freq = new int[26];
        for(int i =0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        while(t!=0){
            int []temp = new int[26];
            if(freq[freq.length-1]!=0){
                temp[0] = freq[freq.length-1];
                temp[1] = freq[freq.length-1];
            }
            for(int i=0;i< freq.length;i++){
                if(freq[i]!=0 && i+1 < freq.length){
                    temp[i+1] += freq[i];
                }
            }
            freq = temp;
            t--;
        }
        int res = 0;
        for(int i=0;i< freq.length;i++){
            res+=freq[i];
        }
        return res;

    }
}
