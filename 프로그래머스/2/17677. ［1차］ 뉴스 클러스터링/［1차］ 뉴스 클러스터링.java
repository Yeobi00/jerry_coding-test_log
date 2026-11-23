import java.util.*;

class Solution {
    static int JACARD = 65536;
    
    public int solution(String str1, String str2) {
        Map<String, Integer> cnt1 = count(str1);
        Map<String, Integer> cnt2 = count(str2);
        
        int inter = 0, union = 0;
        
        for (String key: cnt1.keySet()) {
            int c1 = cnt1.get(key);
            int c2 = cnt2.getOrDefault(key, 0);
            inter += Math.min(c1, c2);
            union += Math.max(c1, c2);
        }
        
        for (String key: cnt2.keySet()) {
            if (!cnt1.containsKey(key)) union += cnt2.get(key);
        }
        
        if (union == 0) return JACARD;
        return (int) ((double) inter / union * JACARD );
    }
    
    Map<String, Integer> count(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.toLowerCase();
        
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i), b = s.charAt(i + 1);
            if (a < 'a' || a > 'z' || b < 'a' || b > 'z') continue;
            String str = s.substring(i, i + 2);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        return map;
    }
}