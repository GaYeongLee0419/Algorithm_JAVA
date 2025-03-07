package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        return dfs(0, numbers, target, 0);
    }

    private int dfs(int depth, int[] numbers, int target, int sum) {
        if (depth == numbers.length) {
            if (sum == target) return 1;
            return 0;
        }

        return dfs(depth + 1, numbers, target, sum + numbers[depth])
                + dfs(depth + 1, numbers, target, sum - numbers[depth]);
    }

    private int bfs(int[] numbers, int target) {
        int result = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        for (int i = 0; i < numbers.length; i++) {
            int size = queue.size();

            for (int j = 0; j < queue.size(); j++) {
                int sum = queue.poll();
                queue.add(sum + numbers[i]);
                queue.add(sum - numbers[i]);
            }
        }

        while (!queue.isEmpty()) {
            if (queue.poll() == target)
                result++;
        }

        return result;
    }
}
