class Solution {
    public String solution(int n) {
        String[] numbers = {"1","2","4"};
        int count = 0;

        while(n >= Math.pow(3,count)) {
            n -= Math.pow(3,count++);
        }

        StringBuilder sb = new StringBuilder();
        while(count-- > 0) {
            sb.append(numbers[n%3]);
            n /= 3;
        }

        return sb.reverse().toString();
    }   
}