package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14503 {
    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int n, m;
    static int r, c, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(clean());
    }

    static int clean() {
        int result = 0;

        while (true) {

            //1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[r][c] == 0) {
                map[r][c] = 2;
                result++;
            }

            boolean moved = false;
            //2. 현재 칸의 주변 4칸을 탐색
            for (int i = 0; i < 4; i++) {
                turn_left();
                int nx = r + dx[d], ny = c + dy[d];

                if (isInArea(nx, ny) && map[nx][ny] == 0){
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            // 청소할 공간이 없는 경우 후진
            if (!moved) {
                int back_x = r - dx[d];
                int back_y = c - dy[d];

                if (isInArea(back_x, back_y) && map[back_x][back_y] != 1) {
                    r = back_x;
                    c = back_y;
                } else {
                    break;
                }
            }

        }

        return result;
    }

    // 반 시계 방향으로 90도 회전
    static void turn_left() {
        d = (d + 3) % 4;
    }

    static boolean isInArea(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
