package programmers.level3.여행경로;

import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<String> routes = new PriorityQueue<>();
    public String[] solution(String[][] tickets) {
        visitAllCity(tickets, new boolean[tickets.length], "ICN ", 0);
        return routes.poll().split(" ");
    }

    public void visitAllCity(String[][] tickets, boolean[] used, String visitedCity, int count) {
        if(count == tickets.length) {
            routes.add(visitedCity);
            return;
        }

        for (int i = 0; i < tickets.length ; i++) {
            String currentCity = visitedCity.split(" ")[count];
            if(!used[i] && currentCity.equals(tickets[i][0])) {
                used[i] = true;
                visitAllCity(tickets, used, visitedCity+tickets[i][1]+" ", count+1);
                used[i] = false;
            }
        }
    }
}
