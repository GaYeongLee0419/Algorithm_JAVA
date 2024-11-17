package Level1;

import java.util.Arrays;

public class 최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;

            int[] rows = new int[sizes.length];
            int[] cols = new int[sizes.length];

            for (int i = 0; i < sizes.length; i++) {
                rows[i] = Math.max(sizes[i][0], sizes[i][1]);
                cols[i] = Math.min(sizes[i][0], sizes[i][1]);
            }

            Arrays.sort(rows);
            Arrays.sort(cols);

            answer = rows[rows.length - 1] * cols[cols.length - 1];
            return answer;
        }
    }
}
