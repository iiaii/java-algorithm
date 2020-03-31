package ESTsoft.p4;

import java.util.HashMap;

public class Solution {
    public String solution(String S, String C) {
        String[] names = S.split("; ");
        StringBuilder emails = new StringBuilder();
        HashMap<String,Integer> idMap = new HashMap<>();
        C = C.toLowerCase();
        for (String name : names) {
            String id = getId(name);
            idMap.put(id, idMap.getOrDefault(id,0)+1);
            emails.append(name).append(" <")
                    .append(id).append(getIdNum(idMap,id)).append("@")
                    .append(C).append(".com>; ");
        }
        return emails.substring(0,emails.length()-2);
    }

    public String getIdNum(HashMap<String,Integer> idMap, String id) {
        return idMap.get(id) == 1 ? "" : idMap.get(id)+"";
    }

    public String getId(String name) {
        String[] words = name.replace("-","").split(" ");
        return (words[words.length-1]+"_"+words[0]).toLowerCase();
    }
}
