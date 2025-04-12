package Implement;

import java.util.*;

public class WordChange {

    public int solution(String begin, String target, String[] words) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        Map<String, Boolean> visited = new HashMap<>();
        pq.offer(new Pair(begin, 0));
        visited.put(begin, true);

        while (!pq.isEmpty()) {
            Pair now = pq.poll();

            if (now.word.equals(target)) return now.distance;

            for (String word : words) {
                if (!visited.get(word) && compareDifference(now.word, word)) {
                    pq.offer(new Pair(word, now.distance + 1));
                    visited.put(word, true);
                }
            }
        }

        return 0;
    }
    public boolean compareDifference(String now, String next) {
        int difference = 0;

        for (int i = 0 ; i < now.length(); i++) {
            if (now.charAt(i) != next.charAt(i)) difference++;
        }

        return difference == 1;
    }
}

class Pair {
    String word;
    int distance;

    public Pair(String word, int distance) {
        this.word = word;
        this.distance = distance;
    }
}
