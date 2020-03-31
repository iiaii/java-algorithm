package ESTsoft.p3;

import java.util.LinkedList;

public class Solution {
    public int solution(int[] A) {
        if(isZigzag(getSequence(A,-1))) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < A.length ; i++) {
            count += isZigzag(getSequence(A, i)) ? 1 : 0;
        }
        return count == 0 ? -1 : count;
    }

    public LinkedList<Integer> getSequence(int[] A, int exclude) {
        LinkedList<Integer> sequence = new LinkedList<>();
        for (int i = 0; i < A.length ; i++) {
            if(i != exclude) {
                sequence.add(A[i]);
            }
        }
        return sequence;
    }

    public boolean isZigzag(LinkedList<Integer> sequence) {
        int prevValue = sequence.poll();
        int prevGradient = nextGradient(sequence, prevValue);
        prevValue = sequence.poll();
        while(!sequence.isEmpty()) {
            if(prevGradient == 0) {
                return false;
            }
            if(nextGradient(sequence, prevValue) == 0) {
                return false;
            }
            if(isPositive(prevGradient) == isPositive(nextGradient(sequence, prevValue))) {
                return false;
            }
            prevGradient = nextGradient(sequence, prevValue);
            prevValue = sequence.poll();
        }
        return true;
    }

    public int nextGradient(LinkedList<Integer> sequence, int prevValue) {
        return sequence.peek()-prevValue;
    }

    public boolean isPositive(int num) {
        return num > 0;
    }
}
