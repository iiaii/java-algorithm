package programmers.level2.영어끝말잇기;

import java.util.HashSet;

public class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordsHistory = new HashSet<>();

        wordsHistory.add(words[0]);
        for (int i = 1; i < words.length ; i++) {
            if(!hasSpoken(wordsHistory, words[i]) && isWordChain(words[i], words[i-1])) {
                wordsHistory.add(words[i]);
                continue;
            }
            return new int[]{i%n+1,i/n+1};
        }
        return new int[]{0,0};
    }

    public boolean hasSpoken(HashSet<String> wordsHistory, String word) {
        return wordsHistory.contains(word);
    }

    public boolean isWordChain(String currentWord, String prevWord) {
        return currentWord.startsWith(prevWord.substring(prevWord.length()-1));
    }
}
