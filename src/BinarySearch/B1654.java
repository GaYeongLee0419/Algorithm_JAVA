package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1654 {
    static int K, N;
    static int[] lans;

    static int binarySearch(int start, int end, int target) {

        while (start <= end) {
            int mid = (start + end) / 2;

            if (getCount(mid) >= target) start = mid + 1;
            else end = mid - 1;
        }

        return end;
    }

    static int getCount(int length) {

        int count = 0;

        for (int lan : lans) {
            if (lan <= length) continue;
            count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lans = new int[K];

        int max = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            lans[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lans[i]);
        }

        for (int lan : lans) System.out.println(lan);

        System.out.println(binarySearch(1, max, N));

    }
}
