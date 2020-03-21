package programmers.level2.N개의최소공배수;

import java.util.Arrays;

public class Solution {
    public int solution(int[] arr) {
        return Arrays.stream(arr).reduce(this::getLCM).orElseThrow();
    }

    public int getLCM(int a, int b) {
        return a*b/getGCD(a, b);
    }

    public int getGCD(int a, int b) {
        int rest;
        while((rest = a%b) != 0) {
            a = b;
            b = rest;
        }
        return b;
    }
}
