package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
A = {1, 1, 3, 7, 8}
B = {1, 3, 6}
 */

public class BaekJoon7795 {
    static int t, n, m;
    static int[] a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

//            int count = 0;
//            for (int target : a) {
////                System.out.println(target + " : " + binarySearch(target));
//                count += binarySearch(target);
//            }
//
//            System.out.println(count);
            System.out.println(twoPointer());
        }
    }

    static int binarySearch(int target) {
        int start = 0, end = m - 1, count = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (b[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    static int twoPointer() {
        int pointA = n - 1, pointB = m - 1, count = 0;

        while (pointA >= 0 && pointB >= 0) {
            if (a[pointA] > b[pointB]) {
                count += pointB + 1;
                pointA--;
            } else {
                pointB--;
            }
        }
        return count;
    }
}
