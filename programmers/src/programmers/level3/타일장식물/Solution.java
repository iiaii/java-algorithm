package programmers.level3.타일장식물;

public class Solution {
    public long solution(int N) {
        Long[] tile = new Long[N+1];
        for(int i=0 ; i<=N ; i++) {
            tile[i] = i < 2 ? 1L : tile[i-1]+tile[i-2];
        }
        return tile[N]*2+tile[N-1]*2;
    }
}