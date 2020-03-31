package programmers.kakao_mock_test.p5;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public HashMap<Integer,Integer> parents = new HashMap<>();
    public int solution(int[] stones, int k) {
        int count = 0;

        loop1 : while(true) {
            int min = Arrays.stream(stones).filter(i -> i!=0).min().orElseThrow();
            int currentIndex = 0;
            while(currentIndex < stones.length) {
                if(find(currentIndex)-currentIndex >= k) {
                    break loop1;
                }
                currentIndex = find(currentIndex);
                if(currentIndex >= stones.length) {
                    break;
                }
                stones[currentIndex] -= min;
                if(stones[currentIndex] == 0) {
                    union(currentIndex);
                }
                currentIndex++;
            }
            count += min;
        }
        return count;
    }

    public void union(int x) {
        x = find(x);
        int y = find(x+1);
        parents.put(x,y);
    }

    public int find(int i) {
        if(parents.getOrDefault(i,i) == i) {
            return i;
        }
        int parent = find(parents.getOrDefault(i,i));
        parents.put(i, parent);
        return parent;
    }
}
