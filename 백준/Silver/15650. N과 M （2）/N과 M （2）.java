import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(0, 1);
        System.out.print(sb);
    }

    static void dfs(int depth, int cur) {
        if (depth == m) {
            for (int e : arr) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = cur; i <= n - (m - depth) + 1; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}