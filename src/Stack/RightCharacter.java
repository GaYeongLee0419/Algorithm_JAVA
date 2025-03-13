package Stack;

import java.util.Stack;

public class RightCharacter {
    boolean solution(String s) {

        if (s.charAt(0) == ')')
            return false;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                count++;
            } else {
                if (count == 0) return false;
                count--;
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        RightCharacter right = new RightCharacter();
        System.out.println(right.solution("(()())"));
    }
}
