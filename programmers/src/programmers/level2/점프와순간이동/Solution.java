package programmers.level2.점프와순간이동;

public class Solution {
    public int solution(int n) {
        int count = 0;
        while(n > 0) {
            if(n%2 == 0) {
                n /= 2;
                continue;
            }
            n--;
            count++;
        }
        return count;
    }
}
