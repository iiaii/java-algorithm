package programmers.level3.단속카메라;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int min = Integer.MIN_VALUE;
        int count = 0;
        for(int[] route : routes) {
            if(min < route[0]) {
                min = route[1];
                count++;
            }
        }
        return count;
    }
}