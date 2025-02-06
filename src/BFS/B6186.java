package BFS;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B6186 {

    private static int r;
    private static int c;
    private static String[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();

        Queue<Point> queue = new LinkedList<>();

        graph = new String[c][r];
        for (int i=0; i<r; i++) {
            graph[i] = sc.nextLine().split("");
            for (int j=0; j<c; j++) {
                if(graph[i][j].equals("#")) {
                    queue.add(new Point(i, j));
                }
            }
        }

        System.out.println(bfs(queue));

    }

    private static int bfs(Queue<Point> queue) {
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        int[][] visited = new int[r][c];

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            visited[point.x][point.y] = 1;

            for(int i = 0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] > 0 || graph[nx][ny].equals("#")) continue;

                visited[nx][ny] = visited[point.x][point.y] + 1;
                queue.add(new Point(nx, ny));
            }
        }

        int count = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(visited[i][j] == 0) continue;
                count = Math.max(count, visited[i][j]);
            }
        }
        return count;
    }

}
