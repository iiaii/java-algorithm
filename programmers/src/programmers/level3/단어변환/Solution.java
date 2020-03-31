package programmers.level3.단어변환;

public class Solution {
    public int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        transformWord(words, new boolean[words.length], begin, target, 0);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public void transformWord(String[] words, boolean[] visited, String currentWord, String target, int count) {
        if(currentWord.equals(target)) {
            min = Math.min(min, count);
            return;
        }

        for (int i=0 ; i< words.length ; i++) {
            if(!visited[i] && isChangeable(currentWord, words[i])) {
                visited[i] = true;
                transformWord(words, visited, words[i], target, count+1);
                visited[i] = false;
            }
        }
    }

    public boolean isChangeable(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length() ; i++) {
            count += s1.charAt(i) == s2.charAt(i) ? 1 : 0;
        }
        return s1.length() == count+1;
    }
}
