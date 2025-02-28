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


    }

    static void robot() {
        while (true) {
            //1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (!isCleaning(r, c)) {
                map[r][c] = 1;
            }

            // 현재 칸의 주변 4칸을 탐색
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i], ny = c + dy[i];

                if (isCleaning(nx, ny)) count++;
                else {
                    // 반 시계 방향으로 90도 회전
                    turn_left();
                    // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우
                    if (!isCleaning(r + dx[d], c + dy[d])) {
                        // 바라보는 방향으로 한 칸 전진
                        nx += dx[d];
                        ny += dy[d];

                        if (isInArea(nx, ny)) {
                            r = nx;
                            c = ny;

                        }
                    }
                }
            }
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (count == 4) {
                //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진
                if (isInArea(r - dx[d], c - dy[d])) {
                    r -= dx[d];
                    c -= dy[d];
                }
                //후진 불가능하면 작동 멈춤
                else {

                    break;
                }
            }
        }

    }

    // 현재 칸이 청소되어있는 칸인지 확인
    static boolean isCleaning(int r, int c) {
        return map[r][c] == 1;
    }

    // 반 시계 방향으로 90도 회전
    static void turn_left() {
        d = (d + 3) % 4;
    }

    static boolean isInArea(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
