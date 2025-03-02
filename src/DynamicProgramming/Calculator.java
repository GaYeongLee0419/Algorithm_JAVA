package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int solution1(String arr[]) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numbers.add(Integer.parseInt(arr[i]));
            } else {
                operators.add(arr[i].charAt(0));
            }
        }

        return dfs(numbers, operators);
    }

    private int dfs(List<Integer> numbers, List<Character> operators) {
        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < operators.size(); i++) {
            char operator = operators.get(i);

            List<Integer> newNumbers = new ArrayList<>();
            List<Character> newOperators = new ArrayList<>();

            for (int j = 0; j < numbers.size(); j++) {
                newNumbers.add(numbers.get(j));
            }
            for (int j = 0; j < operators.size(); j++) {
                newOperators.add(operators.get(j));
            }

            int result = calculate1(numbers.get(i), numbers.get(i+1), operator);
            newNumbers.set(i, result);
            newNumbers.remove(i + 1);
            newOperators.remove(i);

            maxVal = Math.max(maxVal, dfs(newNumbers, newOperators));
        }

        return maxVal;
    }

    private int calculate1(int a, int b, char operator) {
        if (operator == '+') {
            return  a+ b;
        } else if (operator == '-') {
            return a - b;
        }

        return 0;
    }

    public int solution2(String[] arr) {
        int size = arr.length / 2 + 1;
        char[] operators = new char[size - 1];
        int[] numbers = new int[size];

        int[][] max = new int[size][size];
        int[][] min = new int[size][size];

        init(max, min, size);
        setNumbersAndOperators(arr, numbers, operators);

        for (int d = 0; d < numbers.length; d++) {
            for (int i = 0; i < numbers.length - d; i++) {
                int j = i + d;
                if (i == j) {
                    max[i][j] = numbers[i];
                    min[i][j] = numbers[i];

                    continue;
                }

                for (int k = i; k < j; k++) {
                    calculate(operators, max, min, i, j, k);
                }
            }
        }

        return max[0][size - 1];

    }

    private void init(int[][] max, int[][] min, int size) {
        for (int i = 0 ; i < size; i++) {
            for (int j = 0; j < size; j++) {
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private void setNumbersAndOperators(String[] arr, int[] numbers, char[] operators) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = Integer.parseInt(arr[i]);
            } else {
                operators[i / 2] = arr[i].charAt(0);
            }
        }
    }

    private void calculate(char[] operators, int[][] max, int[][] min, int i, int j, int k) {
        if (isPlus(operators[k])) {
            max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
            min[i][j] = Math.min(min[i][j], max[i][k] + min[k + 1][j]);
        } else {
            max[i][j] = Math.max(max[i][j], max[i][k] - min[k + 1][j]);
            min[i][j] = Math.min(min[i][j], min[i][k] - max[k + 1][j]);
        }
    }
    private boolean isPlus(char operator) {
        return operator == '+';
    }
}
