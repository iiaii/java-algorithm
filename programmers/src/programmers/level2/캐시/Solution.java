package programmers.level2.캐시;

import java.util.LinkedHashSet;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedHashSet<String> cache = new LinkedHashSet<>();

        int executionTime = 0;
        for (String city : cities) {
            executionTime += addCity(cache, city.toLowerCase());
            if (isFull(cache, cacheSize)) {
                removeEldest(cache);
            }
        }
        return executionTime;
    }

    public int addCity(LinkedHashSet<String> cache, String city) {
        int executionTime = cache.contains(city) ? 1 : 5;
        cache.remove(city);
        cache.add(city);
        return executionTime;
    }

    public void removeEldest(LinkedHashSet<String> cache) {
        cache.remove(cache.toArray(String[]::new)[0]);
    }

    public boolean isFull(LinkedHashSet<String> cache, int cacheSize) {
        return cache.size() > cacheSize;
    }
}
