package programmers.level3.종이접기;

public class Solution {
    public int[] solution(int n) {
        String[] fold = new String[n];
        fold[0] = "0";
        for(int i=1 ; i<n ; i++) {
            fold[i] = fold[i-1]+"0"+reverse(swapZeroOne(fold[i-1]));
        }
        return fold[n-1].chars().map(i -> i-'0').toArray();
    }

    public String swapZeroOne(String num) {
        return num.replaceAll("0","#").replaceAll("1","0").replaceAll("#","1");
    }

    public String reverse(String num) {
        return new StringBuilder(num).reverse().toString();
    }
}
