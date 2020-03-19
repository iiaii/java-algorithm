package programmers.level2.큰수만들기;

public class Solution {
    public String solution(String number, int k) {
        int targetSize = number.length() - k;
        StringBuilder sb = new StringBuilder();

        while(targetSize > sb.toString().length()) {
            MaxNum max = findMaxNum(number, k);
            k -= max.getPosition();
            number = number.substring(max.getPosition()+1);
            sb.append(Character.toString(max.getNum())).append(k == 0 ? number : "");
        }

        return sb.toString();
    }

    public MaxNum findMaxNum(String number, int k) {
        int max = 0;
        int maxPosition = 0;

        for(int i=0 ; i<=k ; i++) {
            char c = number.charAt(i);
            if(max < c) {
                max = c;
                maxPosition = i;
            }
        }

        return new MaxNum(max,maxPosition);
    }
}

class MaxNum {
    private int num;
    private int position;

    public MaxNum(int num, int position) {
        this.num = num;
        this.position = position;
    }

    public int getNum() {
        return num;
    }

    public int getPosition() {
        return position;
    }
}
