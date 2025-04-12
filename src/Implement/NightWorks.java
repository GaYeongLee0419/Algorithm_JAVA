package Implement;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class NightWorks {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b- a);

        for (int i : works) {
            pq.offer(i);
        }

        while (n > 0 && !pq.isEmpty()) {
            int work = pq.poll();
            if (work == 0) break;
            work--;
            pq.offer(work);
            n--;
            for (int i : pq) {
                System.out.println(i);
            }
            System.out.println("============");
        }

        for (int i : pq) {
            System.out.println(i);
        }
        long result = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            result += work * work;
        }

        return result;
    }

    public static void main(String[] args) {
        NightWorks nightWorks = new NightWorks();
        System.out.println(nightWorks.solution(3, new int[] {1, 1}));
    }
}
