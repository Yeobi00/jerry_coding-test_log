import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        ArrayDeque<int[]> bridge = new ArrayDeque<>();
        
        int currentTime = 0;
        int currentWeight = 0;
        
        for (int truckWeight: truck_weights) {
            currentTime++;
            
            while (!bridge.isEmpty() && bridge.peekFirst()[1] <= currentTime) {
                int[] truck = bridge.pollFirst();
                currentWeight -= truck[0];
            }
            
            while (bridge.size() >= bridge_length || currentWeight + truckWeight > weight) {
                currentTime = bridge.peekFirst()[1];
                
                while (!bridge.isEmpty() && bridge.peekFirst()[1] <= currentTime) {
                    int[] truck = bridge.pollFirst();
                    currentWeight -= truck[0];
                }
            }
                
            bridge.addLast(new int[]{ truckWeight, currentTime + bridge_length });
            currentWeight += truckWeight;
        }
    
        return bridge.peekLast()[1];
    }
}