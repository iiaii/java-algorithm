package programmers.level3.N으로표현;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public int solution(int N, int number) {
        LinkedList<HashSet<Long>> allNCases = new LinkedList<>();
        allNCases.add(new HashSet<>(Collections.singletonList((long)N)));
        while(!allNCases.getLast().contains((long)number)) {
            allNCases.add(getNextCase(allNCases, N));
            if(allNCases.size() > 8) {
                return -1;
            }
        }
        return allNCases.size();
    }

    public HashSet<Long> getNextCase(LinkedList<HashSet<Long>> allNCases, int N) {
        HashSet<Long> numbers = new HashSet<>();
        for (int i = 0; i < allNCases.size() ; i++) {
            for (Long num1 : allNCases.get(i)) {
                for (Long num2 : allNCases.get(allNCases.size()-1-i)) {
                    numbers.add(num1+num2);
                    numbers.add(num1-num2);
                    numbers.add(num2-num1);
                    numbers.add(num1*num2);
                    numbers.add(num2 == 0 ? 0 : num1/num2);
                    numbers.add(num1 == 0 ? 0 :num2/num1);
                }
            }
        }
        numbers.add(repeatN(N, allNCases.size()+1));
        return numbers;
    }

    public long repeatN(int N, int count) {
        return Long.parseLong((N+"").repeat(count));
    }
}