package programmers.level2.최댓값과최솟값;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String solution(String s) {
        Object[] sorted = Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(Integer::parseInt)).toArray();
        return sorted[0]+" "+sorted[sorted.length-1];
    }
}
