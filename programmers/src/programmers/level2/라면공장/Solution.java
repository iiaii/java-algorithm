package programmers.level2.라면공장;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        int index = 0;

        while(stock < k) {
            while(index < dates.length && dates[index] <= stock) {
                pq.add(supplies[index++]);
            }
            stock += pq.poll();
            count++;
        }

        return count;
    }
}