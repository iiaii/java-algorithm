package programmers;

import programmers.level2.파일명정렬.Solution;

import java.util.Arrays;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();

        // 입력
        String[][] input = {
                {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}
        };

        String[][] input2 = {
                {"12:00,12:14,!!!,CDEFGAB", "12:00,12:14,HELLO,CDEFGAB", "12:00,12:14,123,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"},
                {"3:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"},
                {"11:50,12:04,HELLO,C#DEFGAB", "12:57,13:02,WORLD,ABCDEF"},
                {"12:00,12:14,HELLO,cdcdcdf"}
        };

        String[][] input3 = {
        };

        for (int i = 0; i < input.length; i++) {
            // 결과
            var result = s.solution(input[i]);


            // 출력
            System.out.println("======== start =========");
            System.out.println(input[i] + "= " + Arrays.toString(result) );
            System.out.println("========= end ==========");
            System.out.println();
        }
    }
}
