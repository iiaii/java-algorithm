package programmers.level2.카카오프렌즈컬러링북;

class Solution {
    public int[][] map;
    public boolean[][] visited;
    public int block_max;
    public int color_count;
    public int[] solution(int m, int n, int[][] picture) {
        map = picture;
        visited = new boolean[m][n];
        block_max = 0;
        int count = 0;

        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                int color = picture[i][j];
                if(!visited[i][j] && color!=0) {
                    color_count = 0;
                    dfs(i,j,color);
                    count++;
                }
            }
        }

        return new int[]{count,block_max};
    }

    public void dfs(int x, int y, int color) {
        if(visited[x][y] || map[x][y]!=color) {
            return;
        }
        visited[x][y] = true;
        color_count++;
        block_max = block_max < color_count ? color_count : block_max;

        if(x+1 < visited.length) {
            dfs(x+1, y, color);
        }
        if(x-1 >= 0) {
            dfs(x-1, y, color);
        }
        if(y+1 < visited[0].length) {
            dfs(x, y+1, color);
        }
        if(y-1 >= 0) {
            dfs(x, y-1, color);
        }
    }
}