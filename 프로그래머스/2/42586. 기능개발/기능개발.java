import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer((100 - progresses[i] - 1) / speeds[i] + 1);
        }
        
        List<Integer> deploys = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int first = q.poll();
            int cnt = 1;
            while (!q.isEmpty() && first >= q.peek()) {
                q.poll();
                cnt++;
            }
            deploys.add(cnt);
        }
        
        int[] result = new int[deploys.size()];
        for (int i = 0; i < deploys.size(); i++) {
            result[i] = deploys.get(i);
        }
        return result;
    }
}