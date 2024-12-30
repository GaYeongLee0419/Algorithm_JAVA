package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M_1 {
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static int n, m;
    public static void dfs(int depth) {
        if (depth == m) {
            for (int value : arr) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i+1]) {
                visit[i+1] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i+1] = false; // backtracking
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n+1];

        dfs(0);
        System.out.println(sb);
    }
}
