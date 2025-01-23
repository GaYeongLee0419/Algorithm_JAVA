package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 전쟁_전투 {
    static int n;
    static int m;
    static String[][] graph;
    static boolean[][] visited;
    static int count_W = 0;
    static int count_B = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        graph = new String[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            graph[i] = sc.nextLine().split("");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                int count = bfs(i, j, graph[i][j]);
//                System.out.println(graph[i][j] + " " + count);
                if (graph[i][j].equals("W")) count_W += count * count;
                if (graph[i][j].equals("B")) count_B += count * count;
            }
        }

        System.out.println(count_W + " " + count_B);
    }

    static int bfs(int x, int y, String team) {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(x, y);
        queue.offer(node);
        visited[node.x][node.y] = true;

        int count = 1;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && graph[nx][ny].equals(team) && ! visited[nx][ny]) {
                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }

        }

        return count;
    }
}
