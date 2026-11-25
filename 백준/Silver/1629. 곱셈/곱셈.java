import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.print(pow(a, b, c));
    }

    static long pow(long a, long b, long c) {
        if (b == 1) return a % c;

        long half = pow(a, b / 2, c);
        long result = half * half % c;
        if (b % 2 == 1) result = (result * pow(a, 1, c)) % c;

        return result;
    }
}