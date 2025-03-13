package Stack;

import java.util.Stack;

public class RightCharacter {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.substring(0, 1).equals(')'))
            return false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        RightCharacter right = new RightCharacter();
        System.out.println(right.solution("(()())"));
    }
}
