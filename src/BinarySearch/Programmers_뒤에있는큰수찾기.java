package BinarySearch;

public class Programmers_뒤에있는큰수찾기 {
    static class Solution {
        public int[] solution (int[] numbers) {

            int length = numbers.length;
            int[] answer = new int[length];

            int left = 0, right = 1;
            while (right < length) {
                while (numbers[left] >= numbers[right]) {
                    if (right == length - 1) break;
                    right++;
                }

                if (numbers[left] < numbers[right]) answer[left] = numbers[right];
                else answer[left] = -1;
                left++;
                right = left + 1;
            }

            answer[length - 1] = -1;

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {9, 1, 5, 3, 6, 2};
        sol.solution(array);
    }
}
