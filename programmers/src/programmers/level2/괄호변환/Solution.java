package programmers.level2.괄호변환;

import java.util.Stack;

public class Solution {
    public String solution(String p) {
        // step 1
        if(p.equals("")) {
            return p;
        }

        // step 2
        int opened = 0;
        int closed = 0;
        String u = "";
        String v = "";

        for(int i = 0 ; i < p.length() ; i++) {
            if(p.charAt(i) == '(') {
                opened++;
            } else {
                closed++;
            }

            if(opened == closed) {
                u = p.substring(0,i+1);
                v = p.substring(i+1,p.length());
                break;
            }
        }

        // step 3
        Stack<Character> stack = new Stack<>();
        for (char c : u.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) {
                stack.push(c);
                break;
            }
            stack.pop();
        }
        if(stack.isEmpty()) {
            return u + solution(v);
        }

        // step 4
        return "("+solution(v)+")"+ changeString(u.substring(1,u.length()-1));
    }

    public String changeString(String str) {
        return str.replaceAll("\\(","1")
                .replaceAll("\\)","(")
                .replaceAll("1",")");
    }
}
