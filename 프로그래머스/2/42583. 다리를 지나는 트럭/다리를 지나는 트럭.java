import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int total = 0;
        
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int idx = 0;
        
        while (idx < truck_weights.length) {
            int truck = truck_weights[idx];

            total -= bridge.poll();
            
            if (total + truck <= weight) {
                bridge.offer(truck);
                total += truck;
                idx++;
            } else {
                bridge.offer(0);
            }
            
            time++;
        }
        
        return time + bridge_length;
    }
}