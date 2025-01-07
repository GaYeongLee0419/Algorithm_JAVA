package 정렬;

import java.io.*;
import java.util.*;

public class 국영수 {

    public static void solution(String[][] students){
        Arrays.sort(students, (a, b) -> {
            // 1. 국어 점수 내림차순
            int korean = Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
            if (korean != 0) return korean;
            // 2. 영어 점수 오름차순
            int english = Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
            if (english != 0) return english;
            // 3. 수학 점수 오름차순
            int math = Integer.parseInt(b[3]) - Integer.parseInt(a[3]);
            if (math != 0) return math;
            // 4. 이름 사전순
            else return a[0].compareTo(b[0]);
        });

        for (String[] student : students) {
            System.out.println(student[0]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[][] students = new String[n][4];

        for (int i = 0; i < n; i++) {
            students[i] = br.readLine().split(" ");
        }

        solution(students);
    }
}