package programmers.level3.순위;

// 플로이드 와샬 알고리즘 사용
public class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] winBoard = newWinBoard(n);
        setResults(winBoard, results);
        setAllWinRelation(winBoard);
        return countCertainRanking(winBoard);
    }

    public int countCertainRanking(boolean[][] winBoard) {
        int count = 0;
        loop1 : for (int i = 0; i < winBoard.length ; i++) {
            for (int j = 0; j < winBoard.length ; j++) {
                if(!winBoard[i][j] && !winBoard[j][i]) {
                    continue loop1;
                }
            }
            count++;
        }
        return count;
    }

    public void setAllWinRelation(boolean[][] winBoard) {
        for (int k = 0; k < winBoard.length ; k++) {
            for (int i = 0; i < winBoard.length ; i++) {
                for (int j = 0; j < winBoard.length ; j++) {
                    winBoard[i][j] = winBoard[i][k] && winBoard[k][j] || winBoard[i][j];
                }
            }
        }
    }

    public void setResults(boolean[][] winBoard, int[][] results) {
        for (int[] result : results) {
            winBoard[result[0]-1][result[1]-1] = true;
        }
    }

    public boolean[][] newWinBoard(int n) {
        boolean[][] winBoard = new boolean[n][n];
        for (int i = 0; i < n ; i++) {
            winBoard[i][i] = true;
        }
        return winBoard;
    }
}