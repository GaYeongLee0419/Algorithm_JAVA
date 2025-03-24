package Queue;

import java.util.*;

public class DoubleQueue {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

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

        if (minHeap.isEmpty()) {
            return new int[] {0, 0};
        } else if (minHeap.size() == 1) {
            int num = minHeap.poll();
            return new int[] {num, num};
        } else {
            int max = popMaxValue();
            int min = popMinValue();

            return new int[] {max, min};
        }

    }

    public void push(int num) {
        maxHeap.offer(num);
        minHeap.offer(num);
    }

    public int popMaxValue() {
        if (maxHeap.isEmpty()) return Integer.MIN_VALUE;
        int num = maxHeap.poll();
        minHeap.remove(num);

        return num;
    }

    public int popMinValue() {
        if (minHeap.isEmpty()) return Integer.MAX_VALUE;
        int num = minHeap.poll();
        maxHeap.remove(num);

        return num;
    }

    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        DoubleQueue dq = new DoubleQueue();

        int[] result = dq.solution(operations2);

        System.out.println(Arrays.toString(result));
    }
}
