package programmers.level2.프렌즈4블록;

public class Solution {
    public char[][] map;
    public int solution(int m, int n, String[] board) {
        map = generateMap(board);
        boolean[][] marked;
        while (hasSquare(marked = findSquare(new boolean[m][n]))) {
            removeSquare(marked);
        }
        return countSpace();
    }

    public int countSpace() {
        int count = 0;
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[0].length ; j++) {
                count += isEmpty(i,j) ? 1 : 0;
            }
        }
        return count;
    }

    public char[][] generateMap(String[] board) {
        char[][] newMap = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                newMap[i][j] = board[i].charAt(j);
            }
        }
        return newMap;
    }

    public boolean[][] findSquare(boolean[][] marked) {
        for (int i = 0; i < marked.length - 1; i++) {
            for (int j = 0; j < marked[0].length - 1; j++) {
                if (!isEmpty(i,j) && isSquare(i, j)) {
                    markSquare(marked, i, j);
                }
            }
        }
        return marked;
    }

    public void markSquare(boolean[][] marked, int x, int y) {
        marked[x][y] = true;
        marked[x + 1][y] = true;
        marked[x + 1][y + 1] = true;
        marked[x][y + 1] = true;
    }

    public void removeSquare(boolean[][] marked) {
        for (int i = 0; i < marked[0].length; i++) {
            StringBuilder removed = new StringBuilder();
            for (int j = 0; j < marked.length; j++) {
                removed.append(marked[j][i] ? "" : map[j][i]);
            }
            for (int j = 0; j < marked.length; j++) {
                map[j][i] = addSpace(removed.toString(), marked.length - removed.length()).charAt(j);
            }
        }
    }

    public String addSpace(String str, int length) {
        return "#".repeat(length)+str;
    }

    public boolean hasSquare(boolean[][] marked) {
        for (int i = 0; i < marked.length; i++) {
            for (int j = 0; j < marked[0].length; j++) {
                if (marked[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isEmpty(int x, int y) {
        return map[x][y] == '#';
    }

    public boolean isSquare(int x, int y) {
        return isValidIndex(x, y) &&
                map[x][y] == map[x + 1][y] &&
                map[x][y] == map[x + 1][y + 1] &&
                map[x][y] == map[x][y + 1];
    }

    public boolean isValidIndex(int x, int y) {
        return map.length > x + 1 && map[0].length > y + 1;
    }
}
