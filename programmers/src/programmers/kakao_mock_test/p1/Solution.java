package programmers.kakao_mock_test.p1;

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();

        int count = 0;
        Stack<Integer>[] newMap = newMap(board);
        for (int move : moves) {
            if(newMap[move-1].isEmpty()) {
                continue;
            }
            int num = newMap[move-1].pop();
            if(!basket.isEmpty() && num == basket.peek()) {
                basket.pop();
                count += 2;
                continue;
            }
            basket.add(num);
        }
        return count;
    }

    public Stack<Integer>[] newMap(int[][] board) {
        Stack<Integer>[] newMap = new Stack[board.length];
        for (int i = 0; i < board.length ; i++) {
            Stack<Integer> line = new Stack<>();
            for (int j = board.length-1; j >= 0 ; j--) {
                if(board[j][i] == 0) {
                    break;
                }
                line.add(board[j][i]);
            }
            newMap[i] = line;
        }
        return newMap;
    }
}
