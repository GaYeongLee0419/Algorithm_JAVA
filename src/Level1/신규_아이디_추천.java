package Level1;

import java.util.ArrayList;
import java.util.Collections;

public class 신규_아이디_추천 {
    class Solution {
        public String solution(String new_id) {
            String answer = "";

            answer = new_id.toLowerCase();

            answer = answer.replaceAll("[^a-z0-9-_.]", "");

            answer = answer.replaceAll("\\.{2,}", ".");

            if (answer.startsWith(".")) {
                answer = answer.substring(1);
            }
            if (answer.endsWith(".")) {
                answer = answer.substring(0, answer.length() - 1);
            }

            if (answer.isEmpty()) {
                answer = "a";
            }

            if (answer.length() >= 16) {
                answer = answer.substring(0, 15);
                if (answer.endsWith(".")) {
                    answer = answer.substring(0, answer.length() - 1);
                }
            }

            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }

            return answer;
        }
    }

}
