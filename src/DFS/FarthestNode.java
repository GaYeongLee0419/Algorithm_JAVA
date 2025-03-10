package DFS;

import java.util.*;

public class FarthestNode {
    public static int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0 ; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] vertex : edge) {
            graph[vertex[0]].add(vertex[1]);
            graph[vertex[1]].add(vertex[0]);
        }

        return bfs(1, graph);
    }

    public static int bfs(int start, ArrayList<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[graph.length];
        queue.offer(start);
        visited[start] = 1;

        int maxDistance = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    queue.offer(next);
                    maxDistance = Math.max(maxDistance, visited[next]);
                }
            }
        }
        return countMaxDistanceNodes(visited, maxDistance);
    }

    public static int countMaxDistanceNodes(int[] visited, int maxDistance) {
        int count = 0;
        for (int v : visited) {
            if (v == maxDistance) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };

        System.out.println(solution(6, edges));
    }
}


