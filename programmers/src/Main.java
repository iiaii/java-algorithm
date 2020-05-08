

//import programmers.level3.기둥과보설치.Solution;


import java.util.Arrays;


class Solution {
    public int solution(String road, int n) {
        int max = countMaxRoadLength(road, n, 0);
        System.out.println(max);
        for (int i = 0; i < road.length() ; i++) {
            if(road.charAt(i) == '0' && i+1 < road.length()) {
                System.out.println(countMaxRoadLength(road, n, i+1));
                max = Math.max(max, countMaxRoadLength(road, n, i+1));
            }
        }
        return max;
    }

    public int countMaxRoadLength(String road, int n, int currentPos) {
        int count = 0;
        while(currentPos < road.length()) {
            if(road.charAt(currentPos) == '0') {
                n--;
            }
            if(n < 0) {
                break;
            }
            currentPos++;
            count++;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력
        String[] input = {
            "011"
        };

        int[] input2 = {
            1
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
