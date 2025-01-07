package 정렬;

import java.util.*;
import java.io.*;

public class 두_수의_합 {
    public static void solution(int[] numbers, int target) {
        Arrays.sort(numbers);

        int count = 0;
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int a = numbers[start];
            int b = numbers[end];

            if (a+b == target) {
                count++;
                start++;
            } else if (a+b < target) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(count);
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] numList = br.readLine().split(" ");
        int[] numbers = new int[n];
        int target = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n; i++) {
            numbers[i] = Integer.parseInt(numList[i]);
        }

        solution(numbers, target);
    }
}