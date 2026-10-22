import java.util.*;

class Solution {
    static final int[] dr = {1, -1, 0, 0};
    static final int[] dc = {0, 0, 1, -1};
    
    public int solution(String[] maps) {        
        int toLever = bfs(maps, 'S', 'L');
        if (toLever == -1) return -1;
        int toExit = bfs(maps, 'L', 'E');
        if (toExit == -1) return -1;
        
        return toLever + toExit;
    }
    
    int bfs(String[] maps, char from, char to) {
        int row = maps.length;
        int col = maps[0].length();
        
        int[][] dist = new int[row][col];
        for (int[] d: dist) {
            Arrays.fill(d, -1);
        }
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maps[i].charAt(j) == from) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            if (maps[r].charAt(c) == to) return dist[r][c];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                if (dist[nr][nc] != -1) continue;
                if (maps[nr].charAt(nc) == 'X') continue;
                
                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        
        return -1;
    }
}