package programmers;

import programmers.level2.프렌즈4블록.Solution;


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        // 입력
        int[] input = {
                4,
                6
        };

        int[] input2 = {
                5,
                6
        };

        String[][] input3 = {
                {"CCBDE", "AAADE", "AAABF", "CCBBF"},
                {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}
        };

        for (int i = 0; i < input.length; i++) {
            // 결과
            var result = s.solution(input[i], input2[i], input3[i]);

            // 출력
            System.out.println(input[i] + "= " + result);
        }
    }
}
