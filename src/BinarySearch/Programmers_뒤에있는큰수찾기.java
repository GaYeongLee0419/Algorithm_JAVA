package BinarySearch;

import java.util.Stack;

public class Programmers_뒤에있는큰수찾기 {
    static class Solution {
        public int[] solution (int[] numbers) {

            int length = numbers.length;
            int[] answer = new int[length];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < length; i++) {
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                answer[stack.pop()] = -1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {9, 1, 5, 3, 6, 2};
        sol.solution(array);
    }
}
