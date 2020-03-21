package programmers.level2.폰켓몬;

import java.util.Arrays;
import static java.util.stream.Collectors.*;

public class Solution {
    public int solution(int[] nums) {
        return Math.min((nums.length/2), Arrays.stream(nums).boxed().collect(toSet()).size());
    }
}
