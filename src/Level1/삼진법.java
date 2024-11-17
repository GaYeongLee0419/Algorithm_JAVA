package Level1;

public class 삼진법 {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            String temp = "";
            while(n!=0){
                int num = n%3;
                temp += Integer.toString(num);
                n /= 3;
            }
            answer = Integer.parseInt(temp, 3);
            return answer;
        }
    }
}
