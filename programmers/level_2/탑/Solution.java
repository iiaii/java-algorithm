class Solution {
    public int[] solution(int[] heights) {
        int[] result = new int[heights.length];

        for(int i=1 ; i<heights.length ; i++) {
            result[i] = findReceivingTower(heights,i);
        }

        return result;
    }

    int findReceivingTower(int[] heights, int from) {
        for(int i=from-1 ; i>=0 ; i--) {
            if(heights[i] > heights[from]) {
                return i+1;
            }
        }

        return 0;
    }
}