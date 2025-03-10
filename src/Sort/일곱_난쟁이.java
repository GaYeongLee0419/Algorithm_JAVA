package Sort;

import java.io.*;
import java.util.*;

public class 일곱_난쟁이 {
    public static void solution(int[] data){
        int total = Arrays.stream(data).sum();

        Arrays.sort(data);
        int start = 0;
        int end = data.length - 1;

        StringBuilder sb = new StringBuilder();
        while (true) {

            int temp = total - (data[start] + data[end]);
            if (temp == 100) {
                for (int height : data) {
                    if (height != data[start] && height != data[end])
                        sb.append(height).append("\n");
                }
                System.out.println(sb);
                return;
            }
            if (temp > 100) start++;
            else end--;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] heights = new int[9];

        for (int i = 0; i < 9; i++)
            heights[i] = Integer.parseInt(br.readLine());

        solution(heights);
    }
}
