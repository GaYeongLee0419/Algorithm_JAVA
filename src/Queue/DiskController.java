package Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {
    PriorityQueue<Job> waitQ = new PriorityQueue<>((o1, o2) -> {
        if (o1.operateTime != o2.operateTime) return o1.operateTime - o2.operateTime;
        if (o1.regTime != o2.regTime) return o1.regTime - o2.regTime;
        return 0;
    });

    public int solution(int[][] jobs) {
        Queue<Job> queue = new PriorityQueue<>((o1, o2) ->{
            return o1.regTime - o2.regTime;
        });

        for (int i = 0; i < jobs.length; i++) {
            queue.offer(new Job(i, jobs[i][0], jobs[i][1]));
        }

        int currentTime = 0; //현재 시간
        int completedJobs = 0; //완료된 작업 수
        int totalWaitTime = 0; //총 대기 시간
        int jobCount = jobs.length;

        while (completedJobs < jobCount) {
            while (!queue.isEmpty() && queue.peek().regTime <= currentTime) {
                waitQ.offer(queue.poll());
            }

            // 실행할 작업이 있는 경우
            if (!waitQ.isEmpty()) {
                Job job = waitQ.poll();
                currentTime += job.operateTime;
                totalWaitTime += (currentTime - job.regTime);
                completedJobs++;
            } else {
                // 실행할 작업이 없다면 다음 작업의 요청 시간으로 현재 시간 변경
                if (!queue.isEmpty()) {
                    currentTime = queue.peek().regTime;
                }
            }
        }

        return totalWaitTime / jobCount;
    }

    static class Job {
        int number;
        int regTime;
        int operateTime;

        public Job(int number, int regTime, int operateTime) {
            this.number = number;
            this.regTime = regTime;
            this.operateTime = operateTime;
        }
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};

        DiskController controller = new DiskController();
        System.out.println(controller.solution(jobs));
    }

}
