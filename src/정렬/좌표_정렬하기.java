package 정렬;

import java.io.*;
import java.util.*;

public class 좌표_정렬하기 {
    public static void solution(int[][] data) throws IOException {
        Arrays.sort(data, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] coordinate : data) {
            sb.append(coordinate[0]).append(" ").append(coordinate[1]).append("\n");
        }
        System.out.println(sb);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++)
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        solution(data);
    }
}