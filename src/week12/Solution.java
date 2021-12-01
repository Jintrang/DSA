package week12;

import java.util.*;

class Cell {
    public int r, c;

    public Cell(int i, int j) {
        r = i;
        c = j;
    }
}

public class Solution {

    static int[][] grid;
    public static boolean[][] visited;
    static int N, M;


    static int count_connected(int row, int col) {
        int cnt = 0;
        // Viết chương trình vào đây
        if (grid[row][col] == 1 && !visited[row][col]) {
            visited[row][col] = true;
            cnt++;
            if (row < N - 1) cnt += count_connected(row + 1, col);
            if (col < M - 1) cnt += count_connected(row, col + 1);
            if (row > 0 && col > 0) cnt += count_connected(row - 1, col - 1);
            if (row < N - 1 && col < M - 1) cnt += count_connected(row + 1, col + 1);
            if (row > 0) cnt += count_connected(row - 1, col);
            if (col > 0) cnt += count_connected(row, col - 1);
            if (row > 0 && col < M - 1) cnt += count_connected(row - 1, col + 1);
            if (row < N - 1 && col > 0) cnt += count_connected(row + 1, col - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }
}
