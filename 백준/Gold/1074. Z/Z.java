import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int len = 1 << n;

        System.out.print(z(len, r, c));
    }

    static int z(int size, int r, int c) {
        if (size == 2) {
            return 2 * r + c;
        }

        int nr = r, nc = c;
        int idx = 0;
        int half = size / 2;

        if (r >= half) {
            nr -= half;
            idx += 2 * half * half;
        }
        if (c >= half) {
            nc -= half;
            idx += half * half;
        }

        return idx + z(half, nr, nc);
    }
}
