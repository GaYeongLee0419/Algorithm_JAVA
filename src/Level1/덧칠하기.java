package Level1;
import java.util.*;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int num : section) visited.put(num, false);

        int count = 0;
        for (int num : section) {
            if (visited.get(num)) continue;
            for (int i = num; i < num+m; i++){
                if (visited.containsKey(i))
                    visited.put(i, true);
            }
            count++;
        }
        return count;
    }
}
