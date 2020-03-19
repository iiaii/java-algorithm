package programmers.level2.조이스틱;

public class Solution {
    public int solution(String name) {
        int count = 0;
        int restCount = name.replaceAll("A","").length();

        int index = 0;
        int nextMove = 1;
        boolean flag = true;
        while(true) {
            char c = name.charAt(index);

            if(c != 'A') {
                count += Math.min(Math.abs(c-'A'),Math.abs('Z'-c)+1);
                name = name.substring(0,index)+"A"+name.substring(index+1,name.length());
                if(--restCount == 0) {
                    break;
                }
            }

            if(flag && fowardCheck(name, index) > backwardCheck(name, index)) {
                nextMove = nextMove * -1;
                flag = false;
            }

            index += nextMove;
            index = index < 0 ? name.length()-1 : index;
            count++;
        }

        return count;
    }

    public int fowardCheck(String str, int index) {
        int count = 0;
        for(int i=index+1 ; i<str.length() ; i++) {
            count++;
            if(str.charAt(i) != 'A') {
                break;
            }
        }
        return count;
    }

    public int backwardCheck(String str, int index) {
        int count = 0;

        for(int i=str.length()-1 ; i>index ; i--) {
            count++;
            if(str.charAt(str.length()-count) != 'A') {
                break;
            }
        }

        return index+count;
    }
}