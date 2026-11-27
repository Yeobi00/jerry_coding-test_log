import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], -1);
        }
        grid[0][0] = 1;
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        q.offer(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            
            if (r == n - 1 && c == m - 1) return grid[n - 1][m - 1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] != -1) continue;
                if (maps[nr][nc] == 0) continue;
                
                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        
        return -1;
    }
}