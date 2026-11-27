import java.io.*;
import java.util.*;

public class Main {
    static int[][] tomatoes;
    static int m, n;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        tomatoes = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        infect();

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                max = Math.max(max, tomatoes[i][j]);
            }
        }

        System.out.print(max - 1);
    }

    static void infect() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (tomatoes[nr][nc] != 0) continue;

                tomatoes[nr][nc] = tomatoes[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}
