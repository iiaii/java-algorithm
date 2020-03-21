package programmers.level2.짝지어제거하기;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
