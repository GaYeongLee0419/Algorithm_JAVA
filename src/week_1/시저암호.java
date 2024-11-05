package week_1;

public class 시저암호 {
    class Solution {
        public String solution(String str, int n) {
            String answer = "";

            for(char c : str.toCharArray()) {
                if(c >= 'a' && c <= 'z') {
                    c = (char) ((c - 'a' + n) % 26 + 'a');
                }
                else if (c >= 'A' && c <= 'Z') {
                    c = (char) ((c - 'A' + n) % 26 + 'A');
                }

                answer += c;
            }

            return answer;
        }
    }
}
