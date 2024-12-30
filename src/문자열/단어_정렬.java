package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어_정렬 {
    public static void solution(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });

        Arrays.stream(words).distinct().forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        solution(words);
    }
}
