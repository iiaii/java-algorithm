package ESTsoft.p1;

import java.util.HashMap;

public class Solution {
    public int solution(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : A) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int max = 0;
        for (Integer num : map.keySet()) {
            max = num.equals(map.get(num)) ? Math.max(max, num) : max;
        }
        return max;
    }
}
