package Implement;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BFS + 시뮬레이션
public class Baekjoon16236 {
    static int n;
    static int[][] map;
    // 이동 방향 (상, 좌, 우, 하) → 우선순위 고려 (위쪽 먼저)
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int sharkSize = 2, eatCount = 0, totalTime = 0;
    static Node shark;


    static class Node implements Comparable<Node> {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(@NotNull Node o) {
            // 짧은 거리 우선
            if (this.dist != o.dist) return this.dist - o.dist;
            // 위쪽 우선
            if (this.x != o.x) return this.x - o.x;
            // 왼쪽 우선
            return this.y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < n; j++) {
                if (map[i][j] == 9) {
                    shark = new Node(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Node target = bfs();

            if (target == null) {
                System.out.println(totalTime);
                break;
            }

            moveShark(target);
        }

    }

    // 현재 상어의 위치에서 먹을 수 있는 물고기 찾기
    static Node bfs() {
        // 상어가 갈 수 있는 칸 리스트
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new Node(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;

        // 먹을 수 있는 물고기 리스트
        PriorityQueue<Node> fishList = new PriorityQueue<>();
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.dist > minDist) break;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isInArea(nx, ny) && !visited[nx][ny] && map[nx][ny] <= sharkSize) {
                    Node next = new Node(nx, ny, current.dist + 1);
                    queue.offer(next);
                    visited[nx][ny] = true;

                    if (canEat(nx, ny)) {
                        fishList.add(next);
                        minDist = current.dist + 1;
                    }
                }
            }
        }

        return fishList.isEmpty() ? null : fishList.poll();
    }

    static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static boolean canEat(int x, int y) {
        return map[x][y] > 0 && map[x][y] < sharkSize;
    }

    static void moveShark(Node target) {
        shark = new Node(target.x, target.y, 0);
        totalTime += target.dist;
        map[target.x][target.y] = 0;
        eatCount++;

        if (eatCount == sharkSize) {
            sharkSize++;
            eatCount = 0;
        }
    }
}
