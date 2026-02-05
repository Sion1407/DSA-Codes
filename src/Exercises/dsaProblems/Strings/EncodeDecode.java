package Exercises.dsaProblems.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Persons A and B uses an encryption based system for their conversation.
//
//        Each conversation message is encoded from the source and decoded in the destination using a shared private positive number key known to each other.
//
//        The algorithm is illustrated with an example.
//
//        Input Format with explanation:
//
//        1. Operation (1 for Encoding and 2 for Decoding)
//
//        2. Input message
//
//        3. Input private key
//
//        Output Format with explanation:
//
//        1. Output message
//
//        Example 11
//
//        Input:
//
//        1
//
//        Open
//
//        123
//        Output:
//
//        Oppeeen
//
//        Here, the input message characters are duplicated based on each digit in the key.
//
//        Example 21
//
//        Inputs
//
//        2
//
//        Oppeeen
//
//        123
//
//        Output:
//
//        Open
//
//        Here, the input message characters are compressed based on each digit in the key.
//
//        The conversation message and the private key need NOT be in equal length and the encoding / decoding takes place till the end is reached in either the conversation message or private key, while retaining the rest of the conversation message.
//
//        Returns -1 in all exception scenarios
public class EncodeDecode {
    public static void main(String[] args) {
        System.out.println(removeComments(new String[]{"main() { ", "  int a = 1; /* Its comments here ", "", "  ", "  */ return 0;", "} "}));
    }
    public static List<String> removeComments(String[] s) {
        List<String> res = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> rotated = new ArrayList<>(Collections.nCopies(3, 0));
        System.out.println(rotated);
        for(int i =0;i<s.length; i++){
            if(s[i].contains("//")){
                StringBuilder sbb = new StringBuilder();
                for(int j = 0;j<s[i].length();j++){
                    if(s[i].charAt(j) == '/'){
                        break;
                    }
                    else{
                        sbb.append(s[i].charAt(j));
                    }
                }
                if(sbb.length()>0) res.add(sbb.toString());
            } else if (s[i].contains("/*") && s[i].contains("*/")) {
                continue;
            } else if(s[i].contains("/*")){
                inBlock = true;
                sb = new StringBuilder();
                for(int j = 0;j<s[i].length();j++){
                    if(s[i].charAt(j) == '/'){
                        break;
                    }
                    else{
                        sb.append(s[i].charAt(j));
                    }
                }
            }
            else if(inBlock && s[i].contains("*/")){
                inBlock = false;
                int j = s[i].length()-1;
                StringBuilder sbRev = new StringBuilder();
                for(;j>=0;j--){
                    if(s[i].charAt(j) == '/'){
                        break;
                    }
                    else{
                        sbRev.append(s[i].charAt(j));
                    }
                }
                String f = sb +sbRev.reverse().toString();
                if(f.length()>0) res.add(f);
            }
            else if(!inBlock){
                res.add(s[i]);
            }
        }
        return res;
    }



}
