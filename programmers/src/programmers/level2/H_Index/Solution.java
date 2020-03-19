package programmers.level2.H_Index;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int max = Arrays.stream(citations).max().orElse(0);

        for (int h = 0; h <= max ; h++) {
            answer = isValidH(h, countHAbove(citations, h), citations.length) ? h : answer;
        }

        return answer;
    }

    public int countHAbove(int[] citations, int h) {
        return (int)Arrays.stream(citations).filter(citation -> citation >= h).count();
    }

    public boolean isValidH(int h, int hAbove, int citationsSize) {
        return h <= hAbove && citationsSize-hAbove <= h;
    }
}
