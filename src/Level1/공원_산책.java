package Level1;

import java.util.HashMap;
import java.util.Map;

public class 공원_산책 {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            // 동 남 서 북
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            // 시작 지점
            int x = 0, y = 0;
            for ( int i = 0; i < park.length; i++ ) {
                String s = park[i];
                for ( int j = 0; j < s.length(); j++ ) {
                    if (s.charAt(j) == 'S') {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }

            // 방향 매핑
            Map<String, Integer> direction = new HashMap<>();
            direction.put("E", 0);
            direction.put("S", 1);
            direction.put("W", 2);
            direction.put("N", 3);

            // 산책
            for ( String route : routes ) {
                String[] move = route.split(" ");
                int dir = direction.get(move[0]);
                int steps = Integer.parseInt(move[1]);

                int nx = x, ny = y;
                boolean valid = true;

                // 해당 방향으로 step 만큼 이동하기
                for (int step = 1; step <= steps; step++) {
                    nx += dx[dir];
                    ny += dy[dir];

                    // park를 벗어나는 경우
                    if (nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length()) {
                        valid = false;
                        break;
                    }

                    // 장애물을 만나는 경우
                    if (park[nx].charAt(ny) == 'X') {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    x = nx;
                    y = ny;
                }
            }

            return new int[] {x, y};
        }
    }
}
