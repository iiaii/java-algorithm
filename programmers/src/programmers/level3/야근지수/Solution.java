package programmers.level3.야근지수;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(works).forEach(pq::add);
        while(n-- > 0 && pq.peek() > 0) {
            pq.add(pq.poll()-1);
        }
        return pq.stream().mapToLong(w -> (long)w*w).reduce(Long::sum).orElseThrow();
    }
}
