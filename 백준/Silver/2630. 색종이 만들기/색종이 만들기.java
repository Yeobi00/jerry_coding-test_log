import java.io.*;
import java.util.*;

public class Main {
    static int blue = 0;
    static int white = 0;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rect(0, 0, n);

        StringBuilder sb = new StringBuilder();
        sb.append(white).append("\n").append(blue);
        System.out.print(sb);
    }

    static void rect(int row, int col, int size) {
        int std = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != std) {
                    int half = size / 2;
                    rect(row, col, half);
                    rect(row, col + half, half);
                    rect(row + half, col, half);
                    rect(row + half, col + half, half);
                    return;
                }
            }
        }

        if (std == 1) blue++;
        else white++;
    }
}