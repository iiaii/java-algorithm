package programmers.level2.문자열압축;

public class Solution {
    public int solution(String s) {
        int minSize = s.length();
        int chunkSize = minSize/2+1;

        while(--chunkSize > 0) {
            minSize = Math.min(minSize, compressString(s,s.substring(0,chunkSize)).length());
        }

        return minSize;
    }

    public String compressString(String str, String chunk) {
        int count = 0;
        int chunkSize = chunk.length();
        
        while(str.startsWith(chunk)) {
            str = str.substring(chunkSize);
            count++;
        }
        str = str.length() >= chunkSize ? compressString(str,str.substring(0,chunkSize)) : str;

        return count == 1 ? chunk+str : count+chunk+str;
    }
}
