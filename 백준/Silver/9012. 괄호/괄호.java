import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            boolean isCorrect = true;
            int count = 0;

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c == '(') count++;
                else if (c == ')') count--;

                if (count < 0) isCorrect = false;
            }
            if (count != 0) isCorrect = false;

            sb.append(isCorrect ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
