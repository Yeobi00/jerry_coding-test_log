import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        int row = board.length, col = board[0].length();
        
        int[][] dist = new int[row][col];
        for (int[] d: dist) {
            Arrays.fill(d, -1);
        }
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i].charAt(j) == 'R') {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            
            if (board[r].charAt(c) == 'G') return dist[r][c];
            
            for (int i = 0; i < 4; i++) {
                int nr = r, nc = c;
                
                while (true) {
                    int tr = nr + dr[i];
                    int tc = nc + dc[i];
                    
                    if (tr < 0 || tr >= row || tc < 0 || tc >= col) break;
                    if (board[tr].charAt(tc) == 'D') break;
                    nr = tr; nc = tc;
                }
                
                if (nr == r && nc == c) continue;
                if (dist[nr][nc] != -1) continue;
                
                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        
        return -1;
    }
}