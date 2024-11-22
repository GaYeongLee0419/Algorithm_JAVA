package Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class 대충_만든_자판 {
    public int[] solution(String[] keymap, String[] targets) {
        // 키 배열에서 중복된 문자 제거
        Map<Character, Integer> map = new HashMap<>();
        String keyString = String.join("", keymap);

        // 문자 : 최소 인덱스 매핑
        keyString.chars()
                .distinct()
                .forEach(ch -> {
                    int idx = Integer.MAX_VALUE;
                    for (String keys : keymap) {
                        int temp = keys.indexOf(ch);
                        if (temp != -1) {
                            idx = Math.min(idx, temp);
                        }
                    }
                    map.put((char) ch, idx + 1); // 키에 대해 최소 인덱스 + 1 저장
                });

        // targets 배열에 대해 각 문자 합산 계산
        return Stream.of(targets)
                .mapToInt(target -> {
                    int total = 0;
                    for (char ch : target.toCharArray()) {
                        if (map.containsKey(ch)) {
                            total += map.get(ch);
                        } else {
                            return -1; // 중복이 없으면 -1 반환
                        }
                    }
                    return total;
                })
                .toArray();
    }
}


