package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의_합 {

    public static int solution(String numbers) {
        int answer = 0;
        for (String s : numbers.split("")) {
            answer += Integer.parseInt(s);
        }
        return answer;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String numbers = br.readLine();
        System.out.println(solution(numbers));
    }
}
