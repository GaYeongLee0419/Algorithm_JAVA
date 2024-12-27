package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 그룹_단어_체커 {
    public static boolean solution(String s) {
        boolean answer = true;
        Map<Character, Integer> check = new HashMap<>();

        char before = s.charAt(0);
        check.put(before, 1);
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != before){
                if (check.containsKey(current)) return false;
                check.put(current,1);
            }
            before = current;
        }
        return answer;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            if (solution(s)) count++;

        }
        System.out.println(count);
    }
}
