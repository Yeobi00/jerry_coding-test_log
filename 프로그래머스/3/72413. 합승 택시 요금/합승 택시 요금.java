import java.util.*;

class Solution {
    static final int INF = 100_000_000;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] f: fares) {
            adj[f[0]].add(new int[]{f[1], f[2]});
            adj[f[1]].add(new int[]{f[0], f[2]});
        }
        
        int[] dS = dijkstra(adj, s);
        int[] dA = dijkstra(adj, a);
        int[] dB = dijkstra(adj, b);
        
        int answer = INF;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dS[i] + dA[i] + dB[i]);
        }
        return answer;
    }
    
    int[] dijkstra(List<int[]>[] adj, int start) {
        int[] dist = new int[adj.length];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
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