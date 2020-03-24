package programmers.level2.파일명정렬;

import java.util.PriorityQueue;

public class Solution {
    public String[] solution(String[] files) {
        PriorityQueue<File> fileArrayal = new PriorityQueue<>((a,b) -> {
            if(a.getHead().equals(b.getHead())) {
                if(a.getNumber() == b.getNumber()) {
                    return a.getId() - b.getId();
                }
                return a.getNumber() - b.getNumber();
            }
            return a.getHead().compareTo(b.getHead());
        });
        for (int i = 0; i < files.length ; i++) {
            fileArrayal.add(new File(i, files[i], getHead(files[i]), getNumber(files[i])));
        }
        return toArray(fileArrayal);
    }

    public String[] toArray(PriorityQueue<File> fileArrayal) {
        String[] answer = new String[fileArrayal.size()];
        for (int i = 0; i < answer.length ; i++) {
            answer[i] = fileArrayal.poll().getFileName();
        }
        return answer;
    }

    public String getHead(String file) {
        return file.split("[0-9]+")[0];
    }

    public int getNumber(String file) {
        return Integer.parseInt(file.split("[^0-9]+")[1]);
    }
}

class File {
    private int id;
    private String fileName;
    private String head;
    private int number;

    public File(int id, String fileName, String head, int number) {
        this.id = id;
        this.fileName = fileName;
        this.head = head.toLowerCase();
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getHead() {
        return head;
    }

    public int getNumber() {
        return number;
    }
}
