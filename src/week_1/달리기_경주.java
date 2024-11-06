package week_1;

import java.util.HashMap;
import java.util.Map;

public class 달리기_경주 {
    class Solution {
        public String[] solution(String[] players, String[] callings) {

            int numOfPlayers = players.length;
            Map<String, Integer> ranking = new HashMap<>();

            for (int i=0; i<numOfPlayers ; i++) {
                ranking.put(players[i], i);
            }

            for (String call : callings) {
                // 현재 순위
                int now = ranking.get(call);
                // 앞 사람 이름
                String front = players[now-1];
                // 순위 변경
                players[now] = front;
                players[now-1] = call;

                ranking.replace(call, now-1);
                ranking.replace(front, now);
            }

            return players;
        }
    }
}
