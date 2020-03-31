package programmers.level3.이중우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] data = operation.split(" ");
            if(data[0].equals("I")) {
                Integer num = Integer.valueOf(data[1]);
                minHeap.add(num);
                maxHeap.add(num);
                continue;
            }
            if(data[1].equals("1")) {
                minHeap.remove(maxHeap.poll());
                continue;
            }
            maxHeap.remove(minHeap.poll());
        }
        return minHeap.isEmpty() ? new int[]{0, 0} : new int[]{maxHeap.peek(), minHeap.peek()};
    }
}
