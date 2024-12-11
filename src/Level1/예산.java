package Level1;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;

        for (int need : d) {
            if (budget < need) break;

            budget -= need;
            answer++;
        }
        return answer;
    }
}
