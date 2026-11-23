import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        List<String> cache = new LinkedList<>();
        int total = 0;
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (String c: cities) {
            String city = c.toLowerCase();
            
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                total += 1;
            } else {
                if (cache.size() == cacheSize) cache.remove(0);
                cache.add(city);
                total += 5;
            }
        }
        
        return total;
    }
}