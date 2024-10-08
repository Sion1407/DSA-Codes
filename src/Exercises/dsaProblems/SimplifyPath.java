package Exercises.dsaProblems;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }
    public static String simplifyPath(String path) {
        String res = "";
        Stack<String> stack = new Stack<>();
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') continue;
            String temp = "";
            while (i<path.length() && path.charAt(i)!='/'){
                temp+=path.charAt(i);
                i++;
            }
            if (temp.trim().equals(".")) continue;
            else if (temp.trim().equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            else {
                stack.push(temp);
            }
        }
        if (stack.isEmpty()) return "/";
        while (!stack.isEmpty()){
            res= "/" + stack.pop()+res;
        }
        return res;
    }
}
