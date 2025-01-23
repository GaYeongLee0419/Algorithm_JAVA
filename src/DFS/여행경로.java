package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 여행경로 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[][] tickets = new String[n][2];

        for (int i = 0; i < n; i++) {
            tickets[i] = sc.nextLine().split(" ");
        }

        String[] answer = sol.solution(tickets);
    }

    static class Solution {
        static Map<String, ArrayList<String>> map = new HashMap<>();
        public String[] solution(String[][] tickets) {
            String[] answer = {};

            for (int i = 0; i < tickets.length; i++) {
                String start = tickets[i][0];
                String end = tickets[i][1];

                map.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            }

            ArrayList<String> departureList = map.get("ICN");

            for (String departure : departureList) {
                ArrayList<String> loadMap = new ArrayList<>();
                loadMap.add(departure);

            }

            return answer;
        }


    }
}
