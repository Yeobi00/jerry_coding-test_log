import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        for (int room = 0; room < places.length; room++) {
            boolean valid = true;
            
            for (int r = 0; r < 5 && valid; r++) {
                for (int c = 0; c < 5 && valid; c++) {
                    if (places[room][r].charAt(c) != 'P') {
                        continue;
                    }
                    
                    boolean[][] visited = new boolean[5][5];
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    
                    q.offer(new int[]{r, c, 0});
                    visited[r][c] = true;
                    
                    while (!q.isEmpty() && valid) {
                        int[] cur = q.poll();
                        
                        int cr = cur[0];
                        int cc = cur[1];
                        int distance = cur[2];
                        
                        if (distance == 2) continue;
                        
                        for (int d = 0; d < 4; d++) {
                            int nr = cr + dr[d];
                            int nc = cc + dc[d];
                            
                            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                            if (visited[nr][nc]) continue;
                            
                            char next = places[room][nr].charAt(nc);
                            
                            if (next == 'X') continue;
                            if (next == 'P') {
                                valid = false;
                                break;
                            }
                            
                            visited[nr][nc] = true;
                            q.offer(new int[]{nr, nc, distance + 1});
                        }
                    }
                }
            }
            
            answer[room] = valid ? 1 : 0;
        }
        
        return answer;
    }
}