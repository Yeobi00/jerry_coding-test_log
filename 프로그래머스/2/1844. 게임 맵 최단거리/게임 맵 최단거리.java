import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        
        int[][] grid = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            if (r == row - 1 && c == col - 1) return grid[r][c] + 1;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr][nc] == 0) continue;
                
                grid[nr][nc] = grid[r][c] + 1;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        
        return -1;
    }
}