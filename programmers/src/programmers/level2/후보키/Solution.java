package programmers.level2.후보키;

import java.util.HashSet;
import java.util.LinkedList;
import static java.util.stream.Collectors.*;

public class Solution {
    public LinkedList<String> keys = new LinkedList<>();
    public int solution(String[][] relation) {
        generateKeys(relation[0].length, "", 0);
        keys = keys.stream().filter(key -> isValid(relation,key)).collect(toCollection(LinkedList::new));
        excludeDuplicated();
        return keys.size();
    }

    public void generateKeys(int size, String key, int from) {
        if(!key.equals("")) {
            keys.add(key);
        }
        for (int i = from; i < size ; i++) {
            generateKeys(size, key+i, i+1);
        }
    }

    public boolean isValid(String[][] relation, String key) {
        HashSet<String> lines = new HashSet<>();
        for (String[] row : relation) {
            if (!lines.add(getLine(row, key))) {
                return false;
            }
        }
        return true;
    }

    public String getLine(String[] row, String key) {
        StringBuilder line = new StringBuilder();
        key.chars().map(i -> i-'0').forEach(i -> line.append(row[i]));
        return line.toString();
    }

    public void excludeDuplicated() {
        HashSet<String> duplication = new HashSet<>();
        for (String key : keys) {
            for (String target : keys) {
                if(!key.equals(target) && isDuplicated(key, target)) {
                    duplication.add(target);
                }
            }
        }
        keys.removeAll(duplication);
    }

    public boolean isDuplicated(String key, String target) {
        for (char c : key.toCharArray()) {
            if(!target.contains(c+"")) {
                return false;
            }
        }
        return true;
    }
}
