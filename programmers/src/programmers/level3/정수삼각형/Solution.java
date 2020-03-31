package programmers.level3.정수삼각형;

import java.util.Arrays;

public class Solution {
    public static int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length ; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][triangle[i].length-1] += triangle[i-1][triangle[i-1].length-1];
            for (int j = 1; j <triangle[i].length-1 ; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }
        return Arrays.stream(triangle[triangle.length - 1]).max().orElseThrow();
    }
}
