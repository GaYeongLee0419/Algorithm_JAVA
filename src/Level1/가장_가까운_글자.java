package Level1;

import java.util.*;

public class 가장_가까운_글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                answer[i] =i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }
            else {
                map.put(s.charAt(i), i);
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        가장_가까운_글자 sol = new 가장_가까운_글자();
        System.out.println(Arrays.toString(sol.solution("banana")));
    }
}
