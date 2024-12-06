package Level1;

import java.util.ArrayList;

public class 다트_게임 {
    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> scores = new ArrayList<>();

        int number = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char now = dartResult.charAt(i);

            if (Character.isDigit(now)) {
                if (now == '1' && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                    number = 10;
                    i++;
                } else {
                    number = now - '0';
                }
            } else if (now == 'S' || now == 'D' || now == 'T') {
                if (now == 'S') {
                    number = (int) Math.pow(number, 1);
                } else if (now == 'D') {
                    number = (int) Math.pow(number, 2);
                } else if (now == 'T') {
                    number = (int) Math.pow(number, 3);
                }
                scores.add(number);
            } else if (now == '*' || now == '#') {
                int size = scores.size();
                if (now == '*') {
                    scores.set(size - 1, scores.get(size - 1) * 2);
                    if (size > 1) {
                        scores.set(size - 2, scores.get(size - 2) * 2);
                    }
                } else if (now == '#') {
                    scores.set(size - 1, scores.get(size - 1) * -1);
                }
            }
        }

        for (int score : scores) {
            answer += score;
        }

        return answer;
    }

    public static void main(String[] args) {
        다트_게임 sol = new 다트_게임();
        System.out.println(sol.solution("1S2D*3T")); // 예제 1번: 37
        System.out.println(sol.solution("1D2S#10S")); // 예제 2번: 9
        System.out.println(sol.solution("1D2S0T")); // 예제 3번: 3
        System.out.println(sol.solution("1S*2T*3S")); // 예제 4번: 23
        System.out.println(sol.solution("1D#2S*3S")); // 예제 5번: 5
        System.out.println(sol.solution("1T2D3D#")); // 예제 6번: -4
        System.out.println(sol.solution("1D2S3T*")); // 예제 7번: 59
    }
}
