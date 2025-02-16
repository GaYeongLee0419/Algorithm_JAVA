package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2004 {

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        System.out.println(twoPointer(M));
    }

    static int twoPointer(int target) {
        int left = 0, right = 0;
        int count = 0;
        int sum = 0;

        while (right < N) {
            sum += A[right];

            while (sum > target && left <= right) {
                sum -= A[left];
                left++;
            }

            if (sum == target) count++;

            right++;
        }

        return count;
    }
}
