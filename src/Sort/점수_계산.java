package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 점수_계산 {
    public static void solution(int[] data) {
        int[][] scores = new int[8][2];
        for (int i = 0; i < 8; i++) {
            scores[i][0] = data[i];
            scores[i][1] = i + 1;
        }

        // 점수 기준 내림차순
        Arrays.sort(scores, (a, b) -> b[0] - a[0]);

        int sum = 0;
        int[] result = new int[5];
        for (int i = 0; i < 5; i++) {
            sum += scores[i][0];
            result[i] = scores[i][1];
        }

        // 문제 번호 기준 오름차순
        Arrays.sort(result);

        System.out.println(sum);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 5; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] data = new int[8];
        for (int i = 0; i < 8; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        solution(data);
    }
}
