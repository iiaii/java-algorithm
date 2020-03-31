package programmers.level3.저울;

import java.util.Arrays;

public class Solution {
    public int solution(int[] weight) {
        Arrays.sort(weight);
        int answer = 1;
        for (int w : weight) {
            if(answer < w) {
                break;
            }
            answer += w;
        }
        return answer;
    }
}
