package programmers.level3.불량사용자;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public HashSet<String> allCases = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        generateAllCases(getBannedList(user_id, banned_id), new LinkedList<>());
        return allCases.size();
    }

    public List<List<String>> getBannedList(String[] userIds, String[] bannedIds) {
        List<List<String>> bannedList = new LinkedList<>();
        for (String bannedId : bannedIds) {
            bannedList.add(getCandidates(userIds, bannedId));
        }
        return bannedList;
    }

    public void generateAllCases(List<List<String>> bannedList, List<String> combination) {
        if(bannedList.size() == combination.size()) {
            if(isDuplicated(combination)) {
                Collections.sort(combination);
                allCases.add(combination.stream().reduce(String::concat).orElseThrow());
            }
            return;
        }
        for (String id : bannedList.get(combination.size())) {
            combination.add(id);
            generateAllCases(bannedList, combination);
            combination.remove(id);
        }
    }

    public List<String> getCandidates(String[] userIds, String bannedId) {
        return Arrays.stream(userIds)
                .filter(u -> isSimularId(u, bannedId))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean isDuplicated(List<String> ids) {
        return ids.size() == new HashSet<>(ids).size();
    }

    public boolean isSimularId(String userId, String bannedId) {
        if(userId.length() != bannedId.length()) {
            return false;
        }
        for (int i = 0; i < userId.length() ; i++) {
            if(bannedId.charAt(i) == '*') {
                continue;
            }
            if(userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}