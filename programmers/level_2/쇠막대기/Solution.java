import java.util.*;

class Solution {
    public int solution(String arrangement) {
        Stack<Character> sticks = new Stack<>();
        int arrangement_length = arrangement.length();
        int count = 0;
        
        for(int i=0 ; i<arrangement_length ; i++) {
            char c = arrangement.charAt(i);

            if(c == ')') {
                count += canCutSticks(arrangement, i-1) ? sticks.size()-1 : 1;
                sticks.pop();
                continue;
            }
            sticks.add(c);
        }

        return count;
    }

    public boolean canCutSticks(String arrangement, int i) {
        return arrangement.charAt(i) == '(';
    }
}