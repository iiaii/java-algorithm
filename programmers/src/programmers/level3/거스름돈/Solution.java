package programmers.level3.거스름돈;

public class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int m : money) {
            for (int i = 1; i <=n ; i++) {
                dp[i] += i-m >= 0 ? dp[i-m]%1000000007 : 0;
            }
        }
        return dp[n];
    }
}
