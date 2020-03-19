package programmers.level2.소수찾기;

import java.util.*;

public class Solution {
    public Set<Integer> numSet = new HashSet<>();
    public boolean[] primeNumbers;
    
    public int solution(String numbers) {
        generateNumbers(numbers, "", new boolean[numbers.length()]);
        generatePrimeNumbers(Collections.max(numSet));

        return (int) numSet.stream().filter(num -> !primeNumbers[num]).count();
    }

    public void generatePrimeNumbers(int len) {
        primeNumbers = new boolean[len+1];
        primeNumbers[0] = true;
        primeNumbers[1] = true;

        for (int i = 2 ; i <= Math.sqrt(len) ; i++) {
            if(!primeNumbers[i]) {
                excludeMultiples(i, len);
            }
        }
    }

    public void excludeMultiples(int num, int len) {
        for (int j = num+num ; j <= len ; j+=num) {
            primeNumbers[j] = true;
        }
    }

    public void generateNumbers(String numbers, String newNum, boolean[] visited) {
        if(newNum.length() != 0) {
            numSet.add(Integer.parseInt(newNum));
        }
        
        for (int i = 0; i < numbers.length() ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                generateNumbers(numbers, newNum+numbers.substring(i,i+1), visited);
                visited[i] = false;
            }
        }
    }
}