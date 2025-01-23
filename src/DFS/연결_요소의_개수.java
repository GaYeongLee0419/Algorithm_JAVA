package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class 연결_요소의_개수 {
    static int n;
    static int m;

    static boolean[] visited;
    static ArrayList<Integer>[] edgeList;

    static class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];
        edgeList = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++)
            edgeList[i] = new ArrayList<>();

        for (int i = 0 ; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //무방향
            edgeList[a].add(b);
            edgeList[b].add(a);
        }

        int result = 0;

        for (int i = 1; i < n+1; i++) {
            if (!visited[i]){
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    static void dfs(int point) {
        visited[point] = true;
        for (int to : edgeList[point]) {
            if(!visited[to]) dfs(to);
        }
    }
}
