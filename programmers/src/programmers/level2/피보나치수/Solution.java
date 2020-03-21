package programmers.level2.피보나치수;

public class Solution {
    public int solution(int n) {
        int[] fibonacci = new int[n+1];

        fibonacci[1] = 1;
        for(int i=2 ; i<n+1 ; i++) {
            fibonacci[i] = (fibonacci[i-2] + fibonacci[i-1])%1234567;
        }
        return fibonacci[n];
    }
}
