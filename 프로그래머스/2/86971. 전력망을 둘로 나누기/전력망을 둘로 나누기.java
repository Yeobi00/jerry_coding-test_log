import java.util.*;

class Solution {
    
    private List<Integer>[] nodes;
    private int totalNodes;
    private int answer;
    
    public int solution(int n, int[][] wires) {
        
        totalNodes = n;
        answer = Integer.MAX_VALUE;
        
        nodes = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int n1 = wires[i][0];
            int n2 = wires[i][1];
            
            nodes[n1].add(n2);
            nodes[n2].add(n1);
        }
        
        dfs(1, 0);
        
        return answer;
    }
    
    private int dfs(int current, int parent) {
        int subtreeSize = 1;
        
        for (int next : nodes[current]) {
            if (next == parent) continue;
            
            int childSize = dfs(next, current);
            subtreeSize += childSize;
            
            int difference = Math.abs(totalNodes - 2 * childSize);
            answer = Math.min(answer, difference);
        }
        
        return subtreeSize;
    }
}