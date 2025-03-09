package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNumber {
    public static String solution(int[] numbers) {
//        List<Integer> makeNumList = new ArrayList<>();
//        boolean[] visited = new boolean[numbers.length];
//
//        dfs(numbers, 0, visited, "", makeNumList);
//
//        makeNumList.sort((o1, o2) -> {
//            return o2 - o1;
//        });
//
//        return makeNumList.get(0).toString();

        return getMaxNumber(numbers);
    }

    public static void dfs(int[] numbers, int depth, boolean[] visited, String number, List<Integer> makeNumList) {
        if (depth == numbers.length) {
            makeNumList.add(Integer.valueOf(number));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, depth + 1, visited, number + numbers[i], makeNumList);
                visited[i] = false;
            }
        }
    }

    public static String getMaxNumber(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        if (strNumbers[0].equals("0")) return "0";

        return String.join("", strNumbers);
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        String answer = solution(numbers);
        System.out.println(answer);
    }
}
