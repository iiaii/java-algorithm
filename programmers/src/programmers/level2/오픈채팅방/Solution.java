package programmers.level2.오픈채팅방;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public HashMap<String, String> id = new HashMap<>();
    public String[] solution(String[] record) {
        Arrays.stream(record).filter(s -> !s.startsWith("Leave")).forEach(this::setId);
        return Arrays.stream(record).filter(s -> !s.startsWith("Change")).map(this::getHistory).toArray(String[]::new);
    }

    public void setId(String line) {
        String[] data = line.split(" ");
        id.put(data[1], data[2]);
    }

    public String getHistory(String line) {
        String[] data = line.split(" ");
        return id.get(data[1])+(data[0].equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.");
    }
}