package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GiveNoOfFilePathsAvailable {
    public static void main(String[] args) {
        String[] system = new String[]{
                "C:/users/taha/desktop/dev/tmp/index.html",
                "C:/users/taha/desktop/dev/tmp/sampleFile.json",
                "C:/users/guest/desktop/tmp/init.js",
                "C:/users/guest/desktop/dev/tmp/sampleFile.json",
                "C:/users/taha/tmp/index.html",
                "C:/users/taha/desktop/dev/tmp/init.js",
                "C:/users/taha/desktop/dev/tmp/init.css",
        };
        System.out.println(giveFilePath(system));
    }

    public static Map<String, List<String>> giveFilePath(String [] s){
        Map<String,List<String>> hm = new HashMap<>();
        for (int i = 0 ; i < s.length;i++){
            String [] temp = s[i].split("/");
            if (hm.containsKey(temp[temp.length-1])){
                List<String> tempList = hm.get(temp[temp.length-1]);
                tempList.add(s[i]);
                hm.put(temp[temp.length-1],tempList);
            }
            else{
                List<String> tempList = new ArrayList<>();
                tempList.add(s[i]);
                hm.put(temp[temp.length-1], tempList);
            }
        }

        for (Map.Entry<String,List<String>> entry: hm.entrySet()){
            if (entry.getValue().size()==1){
                hm.remove(entry.getKey());
            }
        }
        return hm;
    }
}
