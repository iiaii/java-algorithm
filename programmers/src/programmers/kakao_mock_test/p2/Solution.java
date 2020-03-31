package programmers.kakao_mock_test.p2;

import java.util.*;

public class Solution {
    public int[] solution(String s) {
        PriorityQueue<String> numSet = new PriorityQueue<>(Comparator.comparingInt(String::length));
        numSet.addAll(Arrays.asList(getNumbers(s)));

        LinkedList<Integer> answer = new LinkedList<>();
        HashSet<String> numCheck = new HashSet<>();
        while (!numSet.isEmpty()) {
            for (String num : numSet.poll().split(",")) {
                if(numCheck.add(num)) {
                    answer.add(Integer.parseInt(num));
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public String[] getNumbers(String s) {
        return s.replace("{{","")
                .replace("}}","")
                .split("},\\{");
    }
}
