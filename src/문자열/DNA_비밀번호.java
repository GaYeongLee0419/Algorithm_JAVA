package 문자열;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DNA_비밀번호 {
    public static int solution(String numbers, String words, String rule) {
        int answer = 0;
        int[] nums = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = nums[0];
        int sub_size = nums[1];

        int[] rules = Arrays.stream(rule.split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Character, Integer> countMap = new HashMap<>();
        char[] dna = {'A', 'C', 'G', 'T'};
        for (char c : dna) countMap.put(c, 0);

        for (int i = 0; i < sub_size; i++) {
            char c = words.charAt(i);
            countMap.put(c, countMap.get(c) + 1);
        }

        if (isValid(countMap, rules, dna)) answer++;

        for (int i = sub_size; i < length; i++) {
            char now = words.charAt(i);
            char before = words.charAt(i - sub_size);
            countMap.put(before, countMap.get(before) - 1);
            countMap.put(now, countMap.get(now) + 1);

            if (isValid(countMap, rules, dna)) answer++;
        }

        return answer;
    }

    private static boolean isValid(Map<Character, Integer> countMap, int rules[], char[] dna) {
        for (int i = 0; i < dna.length; i++) {
            if (countMap.get(dna[i]) < rules[i]) return false;
        }

        return true;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        String words = br.readLine();
        String rule = br.readLine();

        System.out.println(solution(numbers, words, rule));

    }
}
