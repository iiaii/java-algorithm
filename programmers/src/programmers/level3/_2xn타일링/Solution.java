package programmers.level3._2xn타일링;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int solution(int n) {
        LinkedList<Integer> tile = new LinkedList<>(Arrays.asList(1,2));
        for (int i = 2; i < n ; i++) {
            tile.add((tile.get(i-1)+tile.get(i-2))%1000000007);
        }
        return tile.get(n-1);
    }
}