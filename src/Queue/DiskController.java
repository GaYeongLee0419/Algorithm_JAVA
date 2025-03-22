package Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> controller = new PriorityQueue<>(((o1, o2) -> {
            if (o1.operateTime != o2.operateTime) return o1.operateTime - o2.operateTime;
            else if (o1.regTime != o2.regTime) return o1.regTime - o2.regTime;
            else return o1.number - o2.number;
        }));

        for (int i = 0; i < jobs.length; i++) {
            controller.offer(new Job(i, jobs[i][0], jobs[i][1]));
        }

        return operate(controller);
    }

    class Job {
        int number;
        int regTime;
        int operateTime;

        public Job (int number, int regTime, int operateTime) {
            this.regTime = regTime;
            this.operateTime = operateTime;
            this.number = number;
        }
    }

    public int operate(Queue<Job> queue) {
        int total = 0;

        while (!queue.isEmpty()) {
            Job job = queue.poll();

            int regTime = job.regTime;
            int operateTime = job.operateTime;
        }
        return total / queue.size();
    }

}
