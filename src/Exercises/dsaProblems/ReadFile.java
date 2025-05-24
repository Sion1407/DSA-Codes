package Exercises.dsaProblems;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
    public static void main(String[] args) {
        String filePath = "C:/Users/sionc/IdeaProjects/DSA/src/Exercises/dsaProblems/test.txt";
        try(BufferedReader bf = new BufferedReader(new FileReader(filePath))){
            StringBuilder sb = new StringBuilder();
            String res;
            while ((res = bf.readLine())!=null){
                sb.append(res);
            }
            Map<String, Integer> hm = new HashMap<>();
            String[] sArr = sb.toString().split(" ");
            for (String s : sArr){
                hm.put(s,hm.getOrDefault(s, 0)+1);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
