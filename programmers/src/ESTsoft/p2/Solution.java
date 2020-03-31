package ESTsoft.p2;

import java.util.HashMap;

public class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int answer = -1;
        for (int i = 0; i < A.length; i++) {
            int sum = addAllNumbers(A[i]);
            if (map.containsKey(sum)) {
                answer = Math.max(answer, map.get(sum) + A[i]);
            }
            map.put(sum, Math.max(map.getOrDefault(sum, 0), A[i]));
        }
        return answer;
    }

    public int addAllNumbers(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
