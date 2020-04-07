package programmers.level3.보행자천국;

public class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] height = new int[m+1][n+1];
        int[][] width = new int[m+1][n+1];
        height[1][1] = 1;
        width[1][1] = 1;
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(cityMap[i-1][j-1] == 0) {
                    height[i][j] = (height[i][j]+height[i-1][j]+width[i][j-1])%MOD;
                    width[i][j] = (width[i][j]+height[i-1][j]+width[i][j-1])%MOD;
                } else if(cityMap[i-1][j-1] == 1) {
                    height[i][j] = 0;
                    width[i][j] = 0;
                } else {
                    height[i][j] = height[i-1][j];
                    width[i][j] = width[i][j-1];
                }
            }
        }
        return (height[m-1][n]+width[m][n-1])%MOD;
    }
}
