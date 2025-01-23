package DFS;

import java.io.IOException;
import java.util.Scanner;

public class 음료수_얼려_먹기 {
    static int n;
    static int m;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static boolean dfs(int x, int y) {
        if (x <= -1 || y <= -1 || x >= n || y >= m) return false;

        if (graph[x][y] == 0) {
            graph[x][y] = 1;

            dfs(x, y+1);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x-1, y);

            return true;
        } else {
            return false;
        }
    }
}
