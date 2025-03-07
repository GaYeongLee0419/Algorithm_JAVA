package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 콘테스트 {
    public static void solution(int[] w, int[] k) {
        Arrays.sort(w);
        Arrays.sort(k);

        int w_total = w[7] + w[8] + w[9];
        int k_total = k[7] + k[8] + k[9];

        System.out.printf("%d %d\n", w_total, k_total);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] w = new int[10];
        int[] k = new int[10];
        for (int i = 0; i < 10; i++){
            w[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 10; i++){
            k[i] = Integer.parseInt(br.readLine());
        }
        solution(w, k);
    }
}
