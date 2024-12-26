package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어_뒤집기2 {
    public static String solution(String word) {
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();

        boolean flag = false; // 태그일 때 true
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '<') {
                flag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(word.charAt(i));
            } else if (word.charAt(i) == '>') {
                sb.append(word.charAt(i));
                flag = false;
            } else if (flag) {
                sb.append(word.charAt(i));
            } else if (!flag) { // 태그가 아닐 때
                if (word.charAt(i) == ' ') { // 새로운 문자로 바뀔 때
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(word.charAt(i));
                } else {
                    stack.push(word.charAt(i));
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String words = br.readLine();
        String answer = solution(words);
        br.close();
        System.out.println(answer);

    }
}
