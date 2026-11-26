import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] cnt;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.print(sb);
    }

    static void dfs(int idx, int result) {
        if (idx == n) {
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for (int k = 0; k < 4; k++) {
            if (cnt[k] == 0) continue;
            cnt[k]--;

            if (k == 0) dfs(idx + 1, result + arr[idx]);
            else if (k == 1) dfs(idx + 1, result - arr[idx]);
            else if (k == 2) dfs(idx + 1, result * arr[idx]);
            else dfs(idx + 1, result / arr[idx]);
            cnt[k]++;
        }
    }
}
