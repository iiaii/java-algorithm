package programmers.level3.가장긴팰린드롬;

public class Solution {
    public int solution(String s) {
        int max = 0;
        for (int i = 0; i < s.length() ; i++) {
            max = Math.max(Math.max(oddPalindromeLength(s, i), evenPalindromeLength(s, i)), max);
        }
        return max;
    }

    public int oddPalindromeLength(String s, int i) {
        return countPalindrome(s, i, i) * 2 + 1;
    }

    public int evenPalindromeLength(String s, int i) {
        return countPalindrome(s, i, i-1) * 2;
    }

    public int countPalindrome(String s, int left, int right) {
        int count = 0;
        while (--left >= 0 && ++right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            count++;
        }
        return count;
    }
}
