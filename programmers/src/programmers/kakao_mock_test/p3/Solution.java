package programmers.kakao_mock_test.p3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public HashMap<String, HashSet<String>> simularIds;
    public HashSet<String> answer = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        simularIds = new HashMap<>();
        findAllSimularIds(user_id, banned_id);
        generateCases(banned_id,"",0);
        return answer.size();
    }

    public void findAllSimularIds(String[] user_id, String[] banned_id) {
        for (String banned : banned_id) {
            HashSet<String> ids = new HashSet<>();
            for (String id : user_id) {
                if(isSimular(id, banned)) {
                    ids.add(id);
                }
            }
            simularIds.put(banned, ids);
        }
    }

    public void generateCases(String[] banned_id, String ids, int from) {
        String[] tmpIds = ids.trim().split(" ");
        if(!ids.equals("") && tmpIds.length == banned_id.length) {
            if(tmpIds.length == new HashSet<>(Arrays.asList(tmpIds)).size()) {
                Arrays.sort(tmpIds);
                answer.add(Arrays.stream(tmpIds).reduce(String::concat).orElseThrow());
            }
            return;
        }

        for (String simularId : simularIds.get(banned_id[from])) {
            generateCases(banned_id, ids+simularId+" ", from+1);
        }
    }

    public boolean isSimular(String id, String banned) {
        if(id.length() != banned.length()) {
            return false;
        }
        for (int i = 0; i < id.length() ; i++) {
            if(banned.charAt(i) == '*') {
                continue;
            }
            if(id.charAt(i) != banned.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
