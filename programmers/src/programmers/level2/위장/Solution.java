package programmers.level2.위장;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(clothes).forEach(cloth -> map.put(cloth[1],map.getOrDefault(cloth[1],1)+1));
        return map.values().stream().reduce((x1, x2) -> x1 * x2).orElseThrow()-1;
    }
}
