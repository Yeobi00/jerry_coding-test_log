import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        if (n == 1 && m == 1) return 1;
        
        int[][] distances = new int[n][m];
        distances[0][0] = 1;
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (distances[nr][nc] > 0) continue;
                if (maps[nr][nc] == 0) continue;
                
                distances[nr][nc] = distances[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        
        return distances[n - 1][m - 1] == 0 ? -1 : distances[n - 1][m - 1];
    }
}