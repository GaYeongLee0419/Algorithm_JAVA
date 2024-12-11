package Level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 추억_점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        List<Integer> answer = new ArrayList<>();

        for (String[] friends : photo) {
            int sum = 0;
            for (String friend : friends) {
                sum += map.getOrDefault(friend, 0);
            }
            answer.add(sum);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
