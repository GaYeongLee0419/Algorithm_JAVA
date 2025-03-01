package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14503v2 {
    static int n, m;
    static int r, c, d;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.println(clean());
    }

    static int clean() {
        int count = 0;
        while (true) {
            if (!isCleaning(r, c)) {
                map[r][c] = 2;
                count++;
            }

            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                turn_left();
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (isInArea(nx, ny) && !isCleaning(nx, ny) && !isWall(nx, ny)) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                int backX = r - dx[d];
                int backY = c - dy[d];

                if (isInArea(backX, backY) && !isWall(backX, backY)) {
                    r = backX;
                    c = backY;
                } else{
                    break;
                }
            }
        }

        return count;
    }

    static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static void turn_left() {
        d = (d + 3) % 4;
    }

    static boolean isCleaning(int x, int y) {
        return map[x][y] == 2;
    }

    static boolean isWall(int x, int y) {
        return map[x][y] == 1;
    }
}
