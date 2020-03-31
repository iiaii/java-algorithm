package programmers.kakao_mock_test.p4;

import java.util.HashMap;

public class Solution {
    HashMap<Long,Long> parents = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length ; i++) {
            answer[i] = find(room_number[i]);
            union(room_number[i]);
        }
        return answer;
    }

    public void union(long x) {
        x = find(x);
        long y = find(x)+1;
        parents.put(x,y);
    }

    public long find(long i) {
        if(!parents.containsKey(i)) {
            return i;
        }
        long parent = find(parents.get(i));
        parents.put(i, parent);
        return parent;
    }
}
