package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 컴백홈 {
    static ArrayList<ArrayList<String>> graph = new ArrayList<>();
    static boolean[][] visited = new boolean[graph.size()][graph.get(0).size()];

    static int count = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < r; i++) {
            graph.add(new ArrayList<>(List.of(sc.next().split(" "))));
        }

        // 시작 위치 : 왼쪽 아래 (r-1, 0)
        int startx = r-1;
        int starty = 0;
        // 도착 위치 : 오른쪽 위 (0, c-1)
        int arrivedx = 0;
        int arrivedy = c-1;




    }

    public static void dfs(int x, int y) {
        // 방문
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[i];
                int ny = y + dy[j];

                if (!visited[nx][ny]) {
                    dfs(nx, ny);

                }
            }
        }
    }
}
