package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class bj16401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        int[] sticks = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
            .toArray();

        Arrays.sort(sticks);
        System.out.println(binarySearch(1, sticks[n - 1], m, sticks));
        sc.close();

    }

    static int binarySearch(int start, int end, int m, int[] sticks) {
        int max = 0;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid == 0) break;

            int count = 0;
            for (int stick : sticks)
                count += stick / mid;

            if(count >= m) {
                max = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return max;
    }

}
