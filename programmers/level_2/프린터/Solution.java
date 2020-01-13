import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
        Printer printer = new Printer(priorities.length);
        printer.setPriorities(priorities);

        while(!(printer.printNextDocument().getIndex() == location)) {}
        
        return printer.getSequence();
    }
}

class Printer {
    private int total_documents;
    private Queue<Document> pending;
    private PriorityQueue<Document> priorities;

    Printer(int total_documents) {
        this.total_documents = total_documents;
        this.pending = new LinkedList<>();
        this.priorities = new PriorityQueue<>(new Comparator<Document>() {
            @Override
            public int compare(Document o1, Document o2) {
                // TODO Auto-generated method stub
                return o2.getPriority()-o1.getPriority();
            }
        });
    }

    void setPriorities(int[] priorities) {
        for(int i=0 ; i<priorities.length; i++) {
            Document document = new Document(i, priorities[i]);
            this.pending.add(document);
            this.priorities.add(document);
        }
    }

    void putBack() {
        this.pending.add(this.pending.remove());
    }

    Document printNextDocument() {
        while(!canPrintDocument()) {
            putBack();
        }

        return print();
    }
    
    Document print() {
        Document document = this.pending.remove();
        this.priorities.remove(document);
        
        return document;
    }
    
    boolean canPrintDocument() {
        return getSupremePriority() == getCurrentPriority();
    }

    int getSupremePriority() {
        return this.priorities.peek().getPriority();
    }

    int getCurrentPriority() {
        return this.pending.peek().getPriority();
    }

    int getSequence() {
        return this.total_documents-this.pending.size();
    }
}

class Document {
    private int index;
    private int priority;

    Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    int getIndex() {
        return this.index;
    }

    int getPriority() {
        return this.priority;
    }
}