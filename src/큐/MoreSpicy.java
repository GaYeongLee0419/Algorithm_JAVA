package 큐;

import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });

        for (int food : scoville) {
            pq.offer(food);
        }

        int count = 0;


        while (pq.size() > 1) {
            int food1 = pq.poll();

            if (food1 >= k) return count;

            int food2 = pq.poll();

            pq.offer(mix(food1, food2));
            count++;

        }

        return -1;
    }

    public int mix(int a, int b) {
        return a + b * 2;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 3, 2, 9, 10, 12};
        MoreSpicy ms = new MoreSpicy();
        System.out.println(ms.solution(scoville, 7));
    }
}
