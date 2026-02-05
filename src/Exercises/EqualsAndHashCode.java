package Exercises;

import java.util.*;

class M1{
    int id;
    M1(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o1){
        if (o1 == this) return true;
        if (o1 == null || getClass() != o1.getClass()) return false; // null or different class
        M1 m = (M1) o1;
        return m.id==id;

    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}



public class EqualsAndHashCode {
    public static void main(String[] args) {
//        M1 m1 = new M1(2);
////        m1.id = 2;
//        M1 m2 = new M1(2);
////        m2.id = 2;
//        System.out.println(m1.equals(m2));
        String[] s = new String[]{"tap","pat","sat","tsa"};
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String str : s){
            char c []= str.toCharArray();
            Arrays.sort(c);
            String sortedStr = new String(c);
            if (hm.get(sortedStr)!=null){
                List<String> ls = hm.get(sortedStr);
                ls.add(str);
                hm.put(sortedStr, ls);
            }
            else {
                hm.put(sortedStr,new ArrayList<>(List.of(str)));
            }
        }
//        System.out.println(hm);
        List<List<String>> res = new ArrayList<>();
        for (List<String> t : hm.values()){
            res.add(t);
        }
        System.out.println(res);
    }
}
