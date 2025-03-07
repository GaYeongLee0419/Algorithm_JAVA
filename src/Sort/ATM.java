package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM {
    public static void solution(int[] data) {
        Arrays.sort(data);
        int sum = 0;
        int temp = 0;

        for (int time : data) {
            temp += time;
            sum += temp;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(input[i]);
        }

        solution(data);
    }
}
