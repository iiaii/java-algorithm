package programmers.level2.소수만들기;

import java.util.Collection;
import java.util.LinkedList;

public class Solution {
    public LinkedList<Integer> numbers = new LinkedList<>();
    public int solution(int[] nums) {
        generateNumbers(nums,0, 0, 0);

        return countPrimeNumber(numbers, getPrimeNumbers(getMax(numbers)));
    }

    public int countPrimeNumber(Collection<Integer> numbers, boolean[] primeNumbers) {
        return (int) numbers.stream().filter(x -> !primeNumbers[x]).count();
    }

    public int getMax(Collection<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElseThrow();
    }

    public boolean[] getPrimeNumbers(int max) {
        boolean[] primeNumbers = new boolean[max+1];
        for (int i = 2; i <= Math.sqrt(max) ; i++) {
            if(!primeNumbers[i]) {
                for (int j = i+i ; j <= max ; j+=i) {
                    primeNumbers[j] = true;
                }
            }
        }
        return primeNumbers;
    }

    public void generateNumbers(int[] nums, int count, int sum, int from) {
        if(count == 3) {
            numbers.add(sum);
            return;
        }

        for (int i = from; i < nums.length ; i++) {
            generateNumbers(nums, count+1, sum+nums[i], i+1);
        }
    }
}