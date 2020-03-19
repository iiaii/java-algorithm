package programmers.level2.숫자야구;

public class Solution {
    public static int numSize = 3;
    public int solution(int[][] baseball) {
        boolean[] numbers = getValidNumbers();

        for (int[] data : baseball) {
            for (int i = 0; i < numbers.length ; i++) {
                numbers[i] = numbers[i] && isValid(data[0] + "", i + "", data[1], data[2]);
            }
        }

        int count = 0;
        for (boolean number : numbers) {
            count += number ? 1 : 0;
        }

        return count;
    }

    public boolean isValid(String num1, String num2, int _strikes, int _balls) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < numSize; i++) {
            if(isStrike(num1, num2, i)) {
                num1 = markNumber(num1, i, "*");
                num2 = markNumber(num2, i, "#");
                strikes++;
            }
        }

        for (int i = 0; i < numSize; i++) {
            balls += isBall(num1, num2, i) ? 1 : 0;
        }

        return strikes == _strikes && balls == _balls;
    }

    public boolean isStrike(String num1, String num2, int index) {
        return num1.charAt(index) == num2.charAt(index);
    }

    public boolean isBall(String num1, String num2, int index) {
        return num2.indexOf(num1.charAt(index)) != -1;
    }

    public String markNumber(String num, int index, String mark) {
        return num.substring(0,index)+mark+num.substring(index+1, numSize);
    }

    public boolean[] getValidNumbers() {
        boolean[] numbers = new boolean[1000];

        for (int i = 0; i < 1000 ; i++) {
            numbers[i] = !isValid(i);
        }

        return numbers;
    }

    public boolean isValid(int num) {
        return num < 100 || String.valueOf(num).contains("0") || isOverlapped(num+"");
    }

    public boolean isOverlapped(String num) {
        for (int i = 0; i < num.length() ; i++) {
            if(num.substring(i+1).contains(num.substring(i,i+1))) {
                return true;
            }
        }
        return false;
    }
}
