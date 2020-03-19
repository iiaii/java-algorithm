package programmers.level2.더맵게;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        for (int scov : scoville) {
            pq.add(scov);
        }

        while(pq.peek() < K) {
            if(pq.size() == 1) {
                return -1;
            }
            pq.add(pq.poll()+(pq.poll()*2));
            count++;
        }

        return count;
    }
}
