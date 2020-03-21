package programmers;

import programmers.level2.올바른괄호.Solution;


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        // 입력
        String[] input = {
                "()()"
        };

        for (int i = 0; i < input.length ; i++) {
            // 결과
            var result = s.solution(input[i]);

            // 출력
            System.out.println(input[i]+"= "+result);
        }
    }
}
