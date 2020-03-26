package programmers;

import programmers.level3.자물쇠와열쇠.Solution;


public class Main {
    public static void main(String[] args) throws Exception {
        // 입력
        int[][][] input = {
                {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}
        };

        int[][][] input2 = {
                {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}
        };

        String[][] input3 = {
        };

        for (int i = 0; i < input.length; i++) {
            // 결과
            var result = new Solution().solution(input[i],input2[i]);


            // 출력
            System.out.println(i+"======== start =========");
            System.out.println(input[i] + "= " + result );
            System.out.println(i+"========= end ==========");
            System.out.println();
        }
    }
}
