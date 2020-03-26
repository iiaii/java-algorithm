//package programmers.level3.브라이언의고민;
//
//import java.util.HashSet;
//
//public class Solution {
//    public StringBuilder origin = new StringBuilder();
//    public HashSet<Character> additives = new HashSet<>();
//    public String solution(String sentence) {
//        try {
//            getNextWord(sentence);
//            return origin.toString().substring(0, origin.length()-1);
//        } catch (Error e) {
//            return "invalid";
//        }
//    }
//
//    public void getNextWord(String sentence) {
//        if(sentence.equals("")) {
//            return;
//        }
//
//        if(!isLowerCase(sentence.charAt(0)) && !isLowerCase(sentence.charAt(1))) {
//            addToOrigin(sentence);
//        }
//
//        if(isLowerCase(sentence.charAt(0)) && !isLowerCase(sentence.charAt(1))) {
//            addToAdditives(sentence.charAt(0));
//            String[] chunks = sentence.substring(1).split(sentence.charAt(0)+"", -1);
//            if(chunks.length == 2) {
//                if(!isLowerCase(chunks[0].charAt(0)) && !isLowerCase(chunks[0].charAt(1))) {
//                    addToOrigin(chunks[0]);
//                } else {
//                    getNextWord(chunks[0]);
//                }
//                getNextWord(chunks[1]);
//            } else {
//                throw new Error();
//            }
//        }
//
//        if(!isLowerCase(sentence.charAt(0)) && isLowerCase(sentence.charAt(1))) {
//            if(sentence.length() <3) {
//                throw new Error();
//            }
//            if(sentence.charAt(1) == sentence.charAt(3)) {
//                addToAdditives(sentence.charAt(1));
//                String[] chunks = sentence.split(sentence.charAt(1)+"", -1);
//                StringBuilder tmpWord = new StringBuilder();
//                for (int i = 0; i < chunks.length-1 ; i++) {
//                    tmpWord.append(chunks[i]);
//                }
//                tmpWord.append(chunks[chunks.length-1].charAt(0));
//                addToOrigin(tmpWord.toString());
//                getNextWord(chunks[chunks.length-1].substring(1));
//            } else {
//                addToOrigin(sentence.charAt(0)+"");
//                getNextWord(sentence.substring(1));
//            }
//        }
//    }
//
//    public void addToOrigin(String word) {
//        StringBuilder newWord = new StringBuilder();
//        for (char c : word.toCharArray()) {
//            if (isLowerCase(c) || c == ' ') {
//                throw new Error();
//            }
//            newWord.append(c);
//        }
//        origin.append(newWord.toString()).append(" ");
//    }
//
//    public void addToAdditives(char c) {
//        if(!additives.add(c)) {
//            throw new Error();
//        }
//    }
//
//    public boolean isLowerCase(char c) {
//        return 'a' <= c && 'z' >= c;
//    }
//}
