package programmers.level2.다음큰숫자;

public class Solution {
    public int solution(int n) {
        int target = countOneFromBinary(n);
        while (countOneFromBinary(++n) != target) {}
        return n;
    }

    public int countOneFromBinary(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }
}
