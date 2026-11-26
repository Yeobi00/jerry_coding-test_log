import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n + 1];

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int e : arr) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            arr[depth] = i;
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}