package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2559 {
    static int N, K;
    static int[] weathers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weathers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) weathers[i] = Integer.parseInt(st.nextToken());

        System.out.println(slidingWindow());
    }

    static int slidingWindow() {
        int sum = 0;
        for (int i = 0; i < K; i++) sum += weathers[i];

        int max = sum;

        for (int i = K; i < N; i++) {
            sum += weathers[i];
            sum -= weathers[i - K];
            max = Math.max(max, sum);
        }

        return max;
    }
}
