package programmers.level3.등굣길;

import java.util.Arrays;

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
        for (int i = 0; i < m ; i++) {
            Arrays.fill(map[i], 1);
        }
        for (int[] puddle : puddles) {
            map[puddle[0]-1][puddle[1]-1] = 0;
        }
        for (int i = 1; i < m ; i++) {
            map[i][0] = map[i-1][0] == 0 ? 0 : map[i][0];
        }
        for (int i = 1; i < n ; i++) {
            map[0][i] = map[0][i-1] == 0 ? 0 : map[0][i];
        }
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n ; j++) {
                map[i][j] = map[i][j] == 0 ? 0 : (map[i-1][j]+map[i][j-1])%1000000007;
            }
        }
        return map[m-1][n-1];
    }
}
