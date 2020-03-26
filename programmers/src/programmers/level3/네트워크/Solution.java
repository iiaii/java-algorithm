package programmers.level3.네트워크;

import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public int solution(int n, int[][] computers) {
        return DFS.dfs(n, computers);
//        return UnionFind.unionFind(n, computers);
    }
}

class UnionFind {
    public static int[] parents;
    public static int unionFind(int n, int[][] computers) {
        parents = newParents(n);
        linkEdges(computers);
        return countNetworks();
    }

    public static int countNetworks() {
        HashSet<Integer> networks = new HashSet<>();
        for (int i = 0; i < parents.length ; i++) {
            networks.add(find(i));
        }
        return networks.size();
    }

    public static void linkEdges(int[][] computers) {
        for (int i = 0; i < computers.length ; i++) {
            for (int j = 0; j < computers[0].length ; j++) {
                if(i != j && computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
    }

    public static int[] newParents(int n) {
        int[] parents = new int[n];
        for (int i = 0; i < n ; i++) {
            parents[i] = i;
        }
        return parents;
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parents[Math.max(x, y)] = Math.min(x, y);
    }

    public static int find(int index) {
        return index == parents[index] ? index : (parents[index] = find(parents[index]));
    }
}

class DFS {
    public static int dfs(int n, int[][] computers) {
        return countNetworks(linkEdges(computers, newNodes(n)));
    }

    public static int countNetworks(Node[] nodes) {
        int count = 0;
        for (int i = 0; i < nodes.length ; i++) {
            if(!nodes[i].isVisited()) {
                count++;
                dfs(nodes[i]);
            }
        }
        return count;
    }

    public static Node[] linkEdges(int[][] computers, Node[] nodes) {
        for (int i = 0; i < computers.length ; i++) {
            for (int j = 0; j < computers[0].length ; j++) {
                if(i != j && computers[i][j] == 1) {
                    nodes[i].getAdjacent().add(nodes[j]);
                    nodes[j].getAdjacent().add(nodes[i]);
                }
            }
        }
        return nodes;
    }

    public static Node[] newNodes(int n) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n ; i++) {
            nodes[i] = new Node(i);
        }
        return nodes;
    }

    public static void dfs(Node node) {
        node.visitCheck();
        for (Node n : node.getAdjacent()) {
            if(!n.isVisited()) {
                dfs(n);
            }
        }
    }

    static class Node {
        private int id;
        private LinkedList<Node> adjacent;
        private boolean visited;

        public Node(int id) {
            this.id = id;
            this.adjacent = new LinkedList<>();
            this.visited = false;
        }

        public int getId() {
            return id;
        }

        public LinkedList<Node> getAdjacent() {
            return adjacent;
        }

        public boolean isVisited() {
            return visited;
        }

        public void visitCheck() {
            visited = true;
        }
    }
}

