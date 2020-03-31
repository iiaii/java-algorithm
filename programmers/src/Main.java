

import programmers.level3.여행경로.Solution;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        // 입력
        String[][][] input = {
                {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
                {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}
        };

        int[] input2 = {
                3
        };

        String[][] input3 = {

        };

        for (int i = 0; i < input.length; i++) {
            // 결과
            var result = new Solution().solution(input[i]);

            // 출력
            System.out.println(i+"======== start =========");
            System.out.println(input[i] + "= " + Arrays.toString(result)  );
            System.out.println(i+"========= end ==========");
            System.out.println();

        }
    }
}
