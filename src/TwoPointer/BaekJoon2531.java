package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2531 {
    static int N, d, k, c;
    static int[] dishes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dishes = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dishes[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(slidingWindow());
    }

    static int slidingWindow() {
        Map<Integer, Integer> sushiMap = new HashMap<>();
        int max = 0, count = 0;

        for (int i = 0; i < k; i++)
            sushiMap.put(dishes[i], sushiMap.getOrDefault(dishes[i], 0) + 1);

        sushiMap.put(c, sushiMap.getOrDefault(c, 0) + 1);
        max = sushiMap.size();

        for (int i = 0; i < N; i++) {
            int left = i;
            sushiMap.put(dishes[left], sushiMap.get(dishes[left]) - 1);
            if (sushiMap.get(dishes[left]) == 0) sushiMap.remove(dishes[left]);

            int right = (i + k) % N;
            sushiMap.put(dishes[right], sushiMap.getOrDefault(dishes[right], 0) + 1);

            max = Math.max(max, sushiMap.size());
        }

        return max;
    }
}
