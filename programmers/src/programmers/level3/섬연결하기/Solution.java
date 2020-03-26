package programmers.level3.섬연결하기;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] costs) {
        return getMinCostLinks(sortLinks(costs), n).stream()
                .map(Link::getCost).reduce(Integer::sum).orElseThrow();
    }

    public PriorityQueue<Link> sortLinks(int[][] costs) {
        PriorityQueue<Link> links = new PriorityQueue<>(Comparator.comparingInt(Link::getCost));
        for (int[] cost : costs) {
            links.add(new Link(cost[0], cost[1], cost[2]));
        }
        return links;
    }

    public LinkedList<Link> getMinCostLinks(PriorityQueue<Link> links, int n) {
        Node[] nodes = newNodes(n);
        LinkedList<Link> minCostLinks = new LinkedList<>();
        while (minCostLinks.size() < n - 1) {
            Link link = links.poll();
            if (!isCircle(nodes, link)) {
                minCostLinks.add(link);
            }
        }
        return minCostLinks;
    }

    public boolean isCircle(Node[] nodes, Link link) {
        addEdges(nodes, link);
        for (Node node : nodes) {
            if (dfs(node, null, new boolean[nodes.length])) {
                removeEdges(nodes, link);
                return true;
            }
        }
        return false;
    }

    public void addEdges(Node[] nodes, Link link) {
        nodes[link.getTo()].getAdjacent().add(nodes[link.getFrom()]);
        nodes[link.getFrom()].getAdjacent().add(nodes[link.getTo()]);
    }

    public void removeEdges(Node[] nodes, Link link) {
        nodes[link.getTo()].getAdjacent().remove(nodes[link.getFrom()]);
        nodes[link.getFrom()].getAdjacent().remove(nodes[link.getTo()]);
    }

    public boolean dfs(Node node, Node prevNode, boolean[] visited) {
        if (visited[node.getId()]) {
            return true;
        }
        visited[node.getId()] = true;
        for (Node n : node.getAdjacent()) {
            if (!n.equals(prevNode) && dfs(n, node, visited)) {
                return true;
            }
        }
        return false;
    }

    public Node[] newNodes(int n) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        return nodes;
    }
}

class Node {
    private int id;
    private LinkedList<Node> adjacent;

    public Node(int id) {
        this.id = id;
        this.adjacent = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public LinkedList<Node> getAdjacent() {
        return adjacent;
    }
}

class Link {
    private int from;
    private int to;
    private int cost;

    public Link(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
}
