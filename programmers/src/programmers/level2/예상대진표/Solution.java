package programmers.level2.예상대진표;

public class Solution {
    public int solution(int n, int a, int b) {
        int count = 0;
        a--;
        b--;
        while(a != b) {
            a /= 2;
            b /= 2;
            count++;
        }
        return count;
    }
}
