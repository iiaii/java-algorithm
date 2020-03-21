package programmers.level2.올바른괄호;

public class Solution {
    public boolean solution(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') {
                count++;
                continue;
            }
            if(--count < 0) {
                break;
            }
        }
        return count == 0;
    }
}
