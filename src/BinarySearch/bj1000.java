package BinarySearch;

import java.util.Scanner;

public class bj1000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double n = sc.nextFloat();

//        System.out.println("정답 : " + Math.sqrt(n));

        double start = 0, end = n;
        double mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            double sqrt = mid * mid;
            if (sqrt == n) break;
            else if (sqrt < n) start = + mid + 1;
            else end = mid - 1;
        }

        System.out.println("binarySearch : " + mid);
    }
}
