package programmers.level2.타겟넘버;

public class Solution {
    public int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;

        permutation(numbers, 0, target, 0);

        return  answer;
    }

    public void permutation(int[] numbers, int index, int target, int result) {
        if(index == numbers.length) {
            answer += target == result ? 1 : 0;
            return;
        }

        permutation(numbers, index+1, target, result+numbers[index]);
        permutation(numbers, index+1, target, result-numbers[index]);
    }
}