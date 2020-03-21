package programmers.level2.단체사진찍기;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String[] names = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public List<String> cases = new LinkedList<>();
    public int solution(int n, String[] data) {
        getAllCases("", new boolean[names.length]);

        return (int)cases.stream().filter((line) -> {
            for (String datum : data) {
                String person1 = datum.substring(0,1);
                String person2 = datum.substring(2,3);
                String op = datum.substring(3,4);
                int distance = Integer.parseInt(datum.substring(4,5));

                if(op.equals("<")) {
                    if(!(getDistance(line, person1, person2) < distance)) {
                        return false;
                    }
                } else if(op.equals(">")) {
                    if(!(getDistance(line, person1, person2) > distance)) {
                        return false;
                    }
                } else {
                    if(!(getDistance(line, person1, person2) == distance)) {
                        return false;
                    }
                }
            }
            return true;
        }).count();
    }

    public int getDistance(String line, String person1, String person2) {
        return Math.abs(line.indexOf(person1)-line.indexOf(person2))-1;
    }

    public void getAllCases(String line, boolean[] visited) {
        if(line.length() == names.length) {
            cases.add(line);
            return;
        }

        for (int i = 0; i < names.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                getAllCases(line+names[i], visited);
                visited[i] = false;
            }
        }
    }
}
