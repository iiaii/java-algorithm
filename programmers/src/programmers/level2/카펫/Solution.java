package programmers.level2.카펫;

public class Solution {
    public int[] solution(int brown, int red) {
        int totalSize = brown+red;
        for(int i=3 ; i<=Math.sqrt(totalSize) ; i++) {
            if(totalSize%i == 0) {
                int width = Math.max(i,totalSize/i);
                int length = totalSize/width;

                if(getRedAmount(width, length) == red) {
                    return new int[]{width,length};
                }
            }
        }
        return new int[]{0,0};
    }

    public int getRedAmount(int width, int length) {
        return (width-2)*(length-2);
    }
}
