package programmers.level2.JadenCase문자열만들기;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

public class Solution {
    public String solution(String s) {
        return stream(s.split(" ",-1)).map(this::toJadenCase).collect(joining(" "));
    }

    public String toJadenCase(String s) {
        return s.length() == 0 ? s : s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase();
    }
}