package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = -1;

        for(int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.contains("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                queue.add(value);
                last = value;
            } else if (command.contains("pop")) {
                if (queue.isEmpty())
                    sb.append("-1\n");
                else{
                    sb.append(queue.remove()).append("\n"); //poll()
                    if (queue.isEmpty()) last = 1;
                }
            } else if (command.contains("front")) {
                if (queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(queue.peek()).append("\n"); //element()
            } else if (command.contains("back")) {
                if (queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(last).append("\n");
            } else if (command.contains("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.contains("empty")) {
                if (queue.isEmpty())
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
        }

        System.out.println(sb);
    }
}
