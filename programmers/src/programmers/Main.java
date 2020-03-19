package programmers;


    import programmers.level2.구명보트.Solution;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        // 입력
        int[][] input = {
                {1, 1, 1, 1, 1},
        };

        int[] target = {
                3,
        };

        for (int i = 0; i < input.length ; i++) {
            // 결과
            int result = s.solution(input[i],target[i]);

            // 출력
            System.out.println(input+"= "+result);
        }

    }
}
