package programmers.level2.숫자의표현;

public class Solution {
    public int solution(int n) {
        int length = 1;
        int from = 0;
        int answer = 0;
        while((from = getFrom(n, length)) > 0) {
            answer += n == accumulation(from, length++) ? 1 : 0;
        }
        return answer;
    }

    public int getFrom(int n, int length) {
        return n/length - (length-1)/2;
    }

    public int accumulation(int from, int length) {
        return (2*from+length-1)*length/2;
    }
}