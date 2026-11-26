import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int cnt = 0;
    static boolean[] usedCol;
    static boolean[] diag1;
    static boolean[] diag2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        usedCol = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        dfs(0);
        System.out.print(cnt);
    }

    static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n - 1;

            if (usedCol[col] || diag1[d1] || diag2[d2]) continue;

            usedCol[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            dfs(row + 1);

            usedCol[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
