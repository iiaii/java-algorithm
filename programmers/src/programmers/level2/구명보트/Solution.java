package programmers.level2.구명보트;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int front = 0;
        int count = 0;

        for (int i = people.length-1 ; i >= front ; i--) {
            front += people[front]+people[i] <= limit ? 1 : 0;
            count++;
        }

        return count;
    }
}