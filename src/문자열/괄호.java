package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import java.io.InputStreamReader;

public class 괄호 {
    public static String solution(String s) {
        String answer = "NO";
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }
        if (stack.isEmpty()) return "YES";
        return answer;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            System.out.println(solution(s));
        }
    }
}
