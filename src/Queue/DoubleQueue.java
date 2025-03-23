package Queue;

import java.util.*;

public class DoubleQueue {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Map<Integer, Integer> countMap = new HashMap<>();

    public int[] solution(String[] operations) {
        for (String operation : operations) {
            String[] data = operation.split(" ");
            String operator = data[0];
            int num = Integer.parseInt(data[1]);

            switch (operator) {
                case "I":
                    push(num);
                    break;

                case "D":
                    if (num == 1) {
                        popMaxValue();
                    }
                    if (num == -1) {
                        popMinValue();
                    }
                    break;
            }

        }

        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return new int[] {0, 0};
        }

        int maxValue = popMaxValue();
        int minValue = popMinValue();

        return new int[] {maxValue, minValue};
    }

    public void push(int num) {
        maxHeap.offer(num);
        minHeap.offer(num);
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    public int poll(Queue<Integer> queue) {
        int result = 0;

        while (!queue.isEmpty()) {
            int number = queue.poll();
            int count = countMap.getOrDefault(number, 0);

            if (count == 0) continue;
            if (count == 1) countMap.remove(number);
            else countMap.put(number, count - 1);

            result = number;
            break;
        }

        return result;
    }

    public int popMaxValue() {
        return poll(maxHeap);
    }

    public int popMinValue() {
        return poll(minHeap);
    }

    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        DoubleQueue dq = new DoubleQueue();

        int[] result = dq.solution(operations2);

        System.out.println(Arrays.toString(result));
    }
}
