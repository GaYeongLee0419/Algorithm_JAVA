package BinarySearch;

import java.util.*;

public class Programmers_징검다리 {
    class Solution {

        public int solution(int distance, int[] rocks, int n) {
            Arrays.sort(rocks);
            int left = 1, right = distance, answer = 0;

            while (left <= right) {
                int mid = (left + right) / 2;
                int removedRocks = 0, prev = 0;

                for (int rock : rocks) {
                    if ((rock - prev) < mid) removedRocks++;
                    else prev = rock;
                }

                if ((distance - prev) < mid) removedRocks++;

                if (removedRocks <= n) left = mid + 1;
                else right = mid - 1;
            }
            return right;
        }
    }
}
