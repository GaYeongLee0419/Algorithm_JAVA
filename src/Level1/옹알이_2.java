package Level1;

import java.util.ArrayList;

public class 옹알이_2 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String bab : babbling) {
            boolean valid = true;
            for (String word : words) {
                if (bab.contains(word + word)) {
                    valid = false;
                    break;
                }
            }
            if (valid && bab.matches("^(aya|ye|woo|ma)+$")) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        옹알이_2 sol = new 옹알이_2();

        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        int result = sol.solution(babbling);
        System.out.println(result);
    }
}
