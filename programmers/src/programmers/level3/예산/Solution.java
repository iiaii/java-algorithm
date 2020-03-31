package programmers.level3.예산;

import static java.util.Arrays.*;

public class Solution {
    public int solution(int[] budgets, int M) {
        int start = 0;
        int end = stream(budgets).max().orElseThrow();
        while(start <= end) {
            int mid = (start+end)/2;
            if(getTotalBudget(budgets, mid) < M) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return end;
    }

    public int getTotalBudget(int[] budgets, int upperLimit) {
        return stream(budgets).map(budget -> Math.min(budget, upperLimit)).reduce(Integer::sum).orElseThrow();
    }
}
