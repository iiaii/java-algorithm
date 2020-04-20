

//import programmers.level3.기둥과보설치.Solution;

import DevMatching.p1.Solution;
//import DevMatching.p2.Solution;
//import DevMatching.p3.Solution;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        // 입력
        String[][] input = {

        };

        String[][] input2 = {

        };

        String[][] input3 = {

        };

        for (int i = 0; i < input.length; i++) {
            // 결과
            var result = new Solution().solution(input[i]);

            // 출력
            System.out.println(i+"======== start =========");
            System.out.println(input[i] + "= " + result );
            System.out.println(i+"========= end ==========");
            System.out.println();

        }
    }
}
