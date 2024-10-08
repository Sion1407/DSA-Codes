package Exercises.dsaProblems;

public class StringCompression {
    static char[] res;
    public static void main(String[] args) {
        res = new char[]{'a','a','a','b','b','a','a'};
        compress(res);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int compress(char[] chars) {
//        if(chars.length == 1)
//            return 1;
//        int l = 0, r = 1,cnt = 1;
//        String s = "";
//        while(r<chars.length){
//            if(chars[l]!=chars[r]){
//                if (cnt == 1)
//                    s+=chars[l];
//                else{
//                    s+=chars[l]+String.valueOf(cnt);
//                    int temp = 0, i = l+1;
//                    String sTemp = String.valueOf(cnt);
//                    while (temp<sTemp.length()){
//                        res[i] = sTemp.charAt(temp);
//                        i++;
//                        temp++;
//                    }
//                }
//                cnt = 1;
//                l=r; r++;
//            }
//            else if(chars[l]==chars[r]){
//                while(r<chars.length && chars[l]==chars[r]){
//                    cnt++;
//                    r++;
//                }
//            }
//            else{
//                // r++;
//                l++;
//            }
//        }
//        if (cnt!=1){
//            s += chars[l] + String.valueOf(cnt);
//            int temp = 0, i = l+1;
//            String sTemp = String.valueOf(cnt);
//            while (temp<sTemp.length()){
//                res[i] = sTemp.charAt(temp);
//                i++;
//                temp++;
//            }
//        }
//        return s.length();


        int ans = 0; // keep track of current position in compressed array

        // iterate through input array using i pointer
        for (int i = 0; i < chars.length;) {
            final char letter = chars[i]; // current character being compressed
            int count = 0; // count of consecutive occurrences of letter

            // count consecutive occurrences of letter in input array
            while (i < chars.length && chars[i] == letter) {
                ++count;
                ++i;
            }

            // write letter to compressed array
            chars[ans++] = letter;

            // if count is greater than 1, write count as string to compressed array
            if (count > 1) {
                // convert count to string and iterate over each character in string
                for (final char c : String.valueOf(count).toCharArray()) {
                    chars[ans++] = c;
                }
            }
        }

        // return length of compressed array
        return ans;

    }
}
