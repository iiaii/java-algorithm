package programmers.level3.가장먼노드;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int n, int[][] edge) {
        Node[] nodes = newNodes(n);
        addEdges(nodes, edge);
        int maxDepth = getMaxDepth(new LinkedList<>(Collections.singletonList(nodes[0])));
        return (int)Arrays.stream(nodes).filter(node -> node.getDepth() == maxDepth).count();
    }

    public int getMaxDepth(Queue<Node> q) {
        int max = 0;
        q.peek().checkVisited();
        while(!q.isEmpty()) {
            Node node = q.poll();
            for (Node nextNode : node.getAdjacent()) {
                if(!nextNode.isVisited()) {
                    nextNode.setDepth(node.getDepth()+1);
                    nextNode.checkVisited();
                    q.add(nextNode);
                }
            }
            max = Math.max(max, node.getDepth());
        }
        return max;
    }

    public void addEdges(Node[] nodes, int[][] edge) {
        for (int[] e : edge) {
            nodes[e[0]-1].getAdjacent().add(nodes[e[1]-1]);
            nodes[e[1]-1].getAdjacent().add(nodes[e[0]-1]);
        }
    }

    public Node[] newNodes(int n) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n ; i++) {
            nodes[i] = new Node(i);
        }
        return nodes;
    }
}

class Node {
    private int id;
    private LinkedList<Node> adjacent;
    private boolean visited;
    private int depth;

    public Node(int id) {
        this.id = id;
        this.adjacent = new LinkedList<>();
        this.visited = false;
        this.depth = 0;
    }

    public LinkedList<Node> getAdjacent() {
        return adjacent;
    }

    public boolean isVisited() {
        return visited;
    }

    public int getDepth() {
        return depth;
    }

    public void checkVisited() {
        visited = true;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
