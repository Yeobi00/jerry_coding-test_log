import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peekLast()[1] > prices[i]) {
                
                int[] previous = stack.pollLast();
                int previousIdx = previous[0];
                
                answer[previousIdx] = i - previousIdx;
            }
            
            stack.addLast(new int[]{i, prices[i]});
        }
        
        while (!stack.isEmpty()) {
            int[] previous = stack.pollLast();
            int previousIdx = previous[0];
            
            answer[previousIdx] = prices.length - 1 - previousIdx;
        }
        
        return answer;
    }
}