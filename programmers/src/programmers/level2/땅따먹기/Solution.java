package programmers.level2.땅따먹기;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                land[i][j] += getMax(land[i - 1], j);
            }
        }
        return Arrays.stream(land[land.length - 1]).max().orElseThrow();
    }

    public int getMax(int[] numbers, int exception) {
        int max = 0;
        for (int i = 0; i < numbers.length ; i++) {
            max = i == exception ? max : Math.max(numbers[i], max);
        }
        return max;
    }
}