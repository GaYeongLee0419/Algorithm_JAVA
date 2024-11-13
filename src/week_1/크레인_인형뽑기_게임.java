package week_1;

import java.util.ArrayList;

public class 크레인_인형뽑기_게임 {
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            ArrayList<Integer> bucket = new ArrayList<>();

            for (int move : moves) {
                int column = move - 1;
                for (int row = 0; row < board.length; row++) {
                    int value = board[row][column];

                    if (value == 0) continue;
                    else{
                        if (!bucket.isEmpty() && bucket.get(bucket.size() - 1) == value) {
                            bucket.remove(bucket.size() - 1);
                            answer += 2;
                        }
                        else {
                            bucket.add(value);
                        }
                        board[row][column] = 0;
                        break;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] move = {1, 5, 3, 5, 1, 2, 1, 4};

        Solution solution = new Solution();

        solution.solution(board, move);
    }
}
