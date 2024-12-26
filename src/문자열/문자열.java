package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열 {
    public static int solution(String x, String y) {
        int answer = Integer.MAX_VALUE;
        int subtract = y.length() - x.length();

        for (int i = 0; i <= subtract; i++) {
            String subStr = y.substring(i, i + x.length());
            if (subStr.equals(x)) return 0;
            else {
                answer = Math.min(answer, count(x, subStr));
            }
        }
        return answer;
    }

    private static int count(String s, String y) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != y.charAt(i)) answer++;
        }

        return answer;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        System.out.println(solution(input[0], input[1]));
    }
}
