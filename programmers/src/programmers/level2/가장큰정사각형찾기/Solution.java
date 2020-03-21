package programmers.level2.가장큰정사각형찾기;

public class Solution {
    public int solution(int[][] board) {
        int max = board[0][0];
        for (int i = 1; i < board.length ; i++) {
            for (int j = 1; j < board[0].length ; j++) {
                max = isSquare(board, i, j) ? Math.max(accumulateValue(board, i, j), max) : max;
            }
        }
        return max*max;
    }

    public boolean isSquare(int[][] board, int x, int y) {
        return board[x][y] != 0;
    }

    public int accumulateValue(int[][] board, int x, int y) {
        return board[x][y] = Math.min(Math.min(board[x-1][y], board[x][y-1]), board[x-1][y-1])+1;
    }
}