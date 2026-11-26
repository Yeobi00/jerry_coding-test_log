import java.io.*;
import java.util.*;

public class Main {
    static int[] pos;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        pos = new int[n];

        dfs(0);

        System.out.print(cnt);
    }

    static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canPlace(row, i)) {
                pos[row] = i;
                dfs(row + 1);
            }
        }
    }

    static boolean canPlace(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (pos[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(col - pos[i])) return false;
        }
        return true;
    }
}
