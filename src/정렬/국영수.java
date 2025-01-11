package 정렬;

import java.io.*;
import java.util.*;

public class 국영수 {

//    public static void solution(String[][] students){
//        Arrays.sort(students, (a, b) -> {
//            // 1. 국어 점수 내림차순
//            int korean = Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
//            if (korean != 0) return korean;
//            // 2. 영어 점수 오름차순
//            int english = Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
//            if (english != 0) return english;
//            // 3. 수학 점수 오름차순
//            int math = Integer.parseInt(b[3]) - Integer.parseInt(a[3]);
//            if (math != 0) return math;
//            // 4. 이름 사전순
//            else return a[0].compareTo(b[0]);
//        });
//
//        for (String[] student : students) {
//            System.out.println(student[0]);
//        }
//    }
    public static void solution(List<Quadruple> data) {

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Quadruple<String, Integer, Integer, Integer>> data = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Quadruple<String, Integer, Integer, Integer> student = new Quadruple(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            data.add(student);
        }

        Collections.sort(data, Comparator.comparing((Quadruple<String, Integer, Integer, Integer> o) -> o.first)
                .thenComparing(Comparator.comparingInt((Quadruple<String, Integer, Integer, Integer> j) -> j.second).reversed())
                .thenComparingInt(o -> o.third)
                .thenComparingInt(o -> o.fourth));

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < data.size(); i++) {
            sb.append(data.get(i).first);
        }
        System.out.println(sb);
    }
}

class Quadruple<F, S, T, O> {
    F first;
    S second;
    T third;
    O fourth;

    public Quadruple(F first, S second, T third, O fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
}