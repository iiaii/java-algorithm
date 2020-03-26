package programmers.level2.n진수게임;

public class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder totalNumber = new StringBuilder("0");
        int num = 1;
        while(totalNumber.length() < (t*m)) {
            totalNumber.append(convertToN(num++,n));
        }
        StringBuilder result = new StringBuilder();
        for (int i = p; i <= (t*m) ; i+=m) {
            result.append(totalNumber.charAt(i-1));
        }
        return result.toString();
    }

    public String convertToN(int value, int n){
        String[] system = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        StringBuilder conversion = new StringBuilder();
        while(value != 0){
            conversion.append(system[value%n]);
            value /= n;
        }
        return conversion.reverse().toString();
    }
}
