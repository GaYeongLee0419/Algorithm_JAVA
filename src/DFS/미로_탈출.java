package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로_탈출 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(graph[n - 1][m - 1]);
    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 범위를 벗어나지 않는지 확인
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // 벽이 아닌 경우
                    if (graph[nx][ny] == 1) {
                        // 최단 거리 갱신
                        graph[nx][ny] = graph[node.x][node.y] + 1;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }
}
