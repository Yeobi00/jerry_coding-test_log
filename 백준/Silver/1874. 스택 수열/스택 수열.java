import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int cur = 1;
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(br.readLine());

            while (cur <= next) {
                stack.addLast(cur++);
                sb.append("+\n");
            }

            if (stack.peekLast() == next) {
                stack.pollLast();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }
        System.out.print(possible ? sb : "NO");
    }
}
