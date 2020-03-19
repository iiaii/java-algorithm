package programmers.level2.가장큰수;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(new int[]{0,0}));
    }
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> (b+a).compareTo((a+b)));
        StringBuilder sb = new StringBuilder();
        
        for(int num : numbers) 
            pq.add(num+"");
        while(!pq.isEmpty()) 
            sb.append(pq.poll());
        
        return sb.toString().substring(0,1).equals("0") ? "0" : sb.toString();
    }
}