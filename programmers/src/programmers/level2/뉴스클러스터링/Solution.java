package programmers.level2.뉴스클러스터링;

import java.util.HashMap;

public class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> map1 = generateMap(str1.toLowerCase());
        HashMap<String, Integer> map2 = generateMap(str2.toLowerCase());

        int intersection = countIntersection(map1, map2);
        int union =  getElementsAmount(map1)+getElementsAmount(map2)-intersection;
        return union == 0 ? 65536 : intersection*65536/union;
    }

    public int getElementsAmount(HashMap<String, Integer> map) {
        return map.values().stream().reduce(Integer::sum).orElse(0);
    }

    public int countIntersection(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        int intersection = 0;
        for (String s : map1.keySet()) {
            intersection += map2.containsKey(s) ? Math.min(map1.get(s), map2.get(s)) : 0;
        }
        return intersection;
    }

    public HashMap<String, Integer> generateMap(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i < str.length() ; i++) {
            String chunk = str.substring(i-1,i+1);
            if(isAlphabet(chunk)) {
                map.put(chunk, map.getOrDefault(chunk,0)+1);
            }
        }
        return map;
    }

    public boolean isAlphabet(String str) {
        for (char c : str.toCharArray()) {
            if(!(c >= 'a' && c <= 'z')) {
                return false;
            }
        }
        return true;
    }
}
