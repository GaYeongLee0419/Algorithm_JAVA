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
}
