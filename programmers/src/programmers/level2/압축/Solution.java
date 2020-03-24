package programmers.level2.압축;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dic = getDictionary();
        LinkedList<Integer> compression = new LinkedList<>();

        for (int i = 0; i < msg.length() ; i++) {
            for (int j = msg.length() ; j > i ; j--) {
                String word = msg.substring(i,j);
                if(dic.containsKey(word)) {
                    compression.add(dic.get(word));
                    if(j != msg.length()) {
                        dic.put(msg.substring(i,j+1),dic.size()+1);
                    }
                    i=j-1;
                    break;
                }
            }
        }
        return compression.stream().mapToInt(Integer::intValue).toArray();
    }

    public HashMap<String, Integer> getDictionary() {
        HashMap<String, Integer> dic = new HashMap<>();
        for (int i = 65; i <= 90 ; i++) {
            dic.put((char)i+"", i-64);
        }
        return dic;
    }
}
