import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int k: course) {
            Map<String, Integer> counts = new HashMap<>();
            
            for (String o: orders) {
                char[] arr = o.toCharArray();
                Arrays.sort(arr);
                dfs(arr, 0, k, new StringBuilder(), counts);
            }
            
            int max = 0;
            for (int v : counts.values()) {
                max = Math.max(max, v);
            }
            
            if (max >= 2) {
                for (Map.Entry<String, Integer> e: counts.entrySet()) {
                    if (e.getValue() == max) {
                        answer.add(e.getKey());
                    }
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    void dfs(char[] order, int idx, int k, StringBuilder cur, Map<String, Integer> counts) {

        if (cur.length() == k) {
            counts.put(cur.toString(), counts.getOrDefault(cur.toString(), 0) + 1);
            return;
        }

        if (idx == order.length) {
            return;
        }
        
        cur.append(order[idx]);
        dfs(order, idx + 1, k, cur, counts);
        cur.deleteCharAt(cur.length() - 1);

        dfs(order, idx + 1, k, cur, counts);
    }
}