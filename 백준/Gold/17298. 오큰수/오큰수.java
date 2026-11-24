import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] < arr[i]) {
                result[stack.pollLast()] = arr[i];
            }
            stack.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int r: result) {
            sb.append(r).append(" ");
        }

        System.out.print(sb.toString());
    }
}
