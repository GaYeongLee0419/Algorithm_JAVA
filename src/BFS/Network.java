package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Network {
    private static ArrayList<Integer>[] graph ;
    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            bfs(i);
            result++;
        }

        return result;
    }

    public void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (visited[next])
                    continue;

                visited[next] = true;
                queue.offer(next);
            }
        }
    }

    public static void main(String[] args) {
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};

        Network network = new Network();
        System.out.println(network.solution(3, computers));
    }
}
