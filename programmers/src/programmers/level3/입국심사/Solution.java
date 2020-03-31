package programmers.level3.입국심사;

import java.util.Arrays;

public class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = (long)Arrays.stream(times).max().orElseThrow()*n;
        long answer = Long.MAX_VALUE;
        while(start <= end) {
            long mid = (start+end)/2;
            if(getPassedCount(times, mid) < n) {
                start = mid+1;
            } else {
                answer = Math.min(answer, mid);
                end = mid-1;
            }
        }
        return answer;
    }

    public long getPassedCount(int[] times, long timeLimit) {
        long count = 0;
        for (int time : times) {
            count += timeLimit/time;
        }
        return count;
    }
}
