package Level1;

import java.sql.SQLOutput;

public class 문자열_나누기 {
    public int solution(String s) {
        int answer = 0 ;

        int x_count = 0;
        int other_count = 0;
        char x = s.charAt(0);

        for (int i = 0; i < s.length() ; i++) {
            char y = s.charAt(i);

            if (x == y) x_count++;
            else other_count++;

            if (x_count == other_count) {
                answer++;

                if (i+1 < s.length()) x = s.charAt(i+1);

                x_count = 0;
                other_count = 0;
            }
        }

        if (x_count != 0 || other_count != 0) {
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        문자열_나누기 sol = new 문자열_나누기();
        System.out.println(sol.solution("aaabbaccccabba"));
    }
}
