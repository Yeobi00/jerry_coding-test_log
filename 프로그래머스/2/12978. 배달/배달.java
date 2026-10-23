import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE / 2;
    
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r: road) {
            adj[r[0]].add(new int[]{r[1], r[2]});
            adj[r[1]].add(new int[]{r[0], r[2]});
        }
        
        int[] dist = dijkstra(adj, 1);
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }
        
        return count;
    }
    
    int[] dijkstra(List<int[]>[] adj, int start) {
        int[] dist = new int[adj.length];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist[u]) continue;
            
            for (int[] e: adj[u]) {
                int v = e[0], w = e[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                } 
            }
        }
        
        return dist;
    }
}