import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = hanoi(n, 1, 2, 3);
        System.out.println(count);
        System.out.print(sb);
    }

    static int hanoi(int n, int from, int via, int to) {
        if (n == 0) return 0;

        int cnt = hanoi(n - 1, from, to, via) + 1;
        sb.append(from).append(" ").append(to).append("\n");
        cnt += hanoi(n - 1, via, from, to);
        return cnt;
    }
}
