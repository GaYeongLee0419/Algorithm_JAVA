package Sort;

import java.util.Arrays;

public class MaxNumber {
    public static String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        String result = String.join("", strNumbers);

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        solution(numbers);
    }
}
