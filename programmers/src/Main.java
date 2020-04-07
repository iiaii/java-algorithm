

//import programmers.level3.기둥과보설치.Solution;
//import Line.p1.Solution;
//import Line.p2.Solution;
//import Line.p3.Solution;
//import Line.p4.Solution;
//import Line.p5.Solution;
import Line.p6.Solution;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        // 입력
        String[][] input = {
                {"/"}
        };

        String[][] input2 = {
                {
                        "mkdir /a",
                        "mkdir /a/b",
                        "mkdir /a/b/c",
                        "cp /a/b /",
                        "rm /a/b/c"
                }
        };

        String[][] input3 = {

        };

        for (int i = 0; i < input.length; i++) {
            // 결과
            var result = new Solution().solution(input[i],input2[i]);

            // 출력
            System.out.println(i+"======== start =========");
            System.out.println(input[i] + "= " + Arrays.toString(result) );
            System.out.println(i+"========= end ==========");
            System.out.println();

        }
    }
}
