package programmers.level3.자물쇠와열쇠;

public class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        lock = newLock(key, lock);
        for (int i = 0; i < 4; i++) {
            if (isValidKey(key = rotate90(key), lock)) {
                return true;
            }
        }
        return false;
    }

    public int[][] newLock(int[][] key, int[][] lock) {
        int[][] newLock = new int[lock.length + (key.length - 1) * 2][lock.length + (key.length - 1) * 2];
        for (int i = key.length - 1; i < key.length + lock.length - 1; i++) {
            for (int j = key.length - 1; j < key.length + lock.length - 1; j++) {
                newLock[i][j] = lock[i - key.length + 1][j - key.length + 1];
            }
        }
        return newLock;
    }

    public boolean isValidKey(int[][] key, int[][] lock) {
        for (int i = 0; i < lock.length - key.length + 1; i++) {
            for (int j = 0; j < lock.length - key.length + 1; j++) {
                if (isValidPosition(insertKey(key, lock, i, j), key.length)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] insertKey(int[][] key, int[][] lock, int x, int y) {
        int[][] insertedLock = deepCopy(lock);
        for (int i = x; i < x + key.length; i++) {
            for (int j = y; j < y + key.length; j++) {
                insertedLock[i][j] += key[i - x][j - y];
            }
        }
        return insertedLock;
    }

    public boolean isValidPosition(int[][] insertedLock, int keySize) {
        for (int i = keySize - 1; i < insertedLock.length - keySize + 1; i++) {
            for (int j = keySize - 1; j < insertedLock.length - keySize + 1; j++) {
                if (insertedLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] rotate90(int[][] arr) {
        int[][] rotation = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                rotation[i][j] = arr[j][arr.length - i - 1];
            }
        }
        return rotation;
    }

    public int[][] deepCopy(int[][] arr) {
        int[][] newArr = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, newArr[i], 0, arr[0].length);
        }
        return newArr;
    }
}
