package BinarySearch;

import java.util.*;
import java.io.*;

public class bj2343 {
    static int[] lectures;
    static int N;

    public static int binarySearch(int start, int end, int target) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (count(mid) > target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return mid;
    }

    public static int count(int mid) {
        int count = 1;
        int remain = mid;

        for (int lecture : lectures) {
            if (remain < lecture) {
                remain = mid;
                count++;
            }
            remain -= lecture;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        lectures = new int[N];

        for (int i = 0; i < N; i++) lectures[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(lectures);
        int sum = Arrays.stream(lectures).sum();
        int max = lectures[N - 1];

        System.out.println(binarySearch(max, sum, M));


    }

}
