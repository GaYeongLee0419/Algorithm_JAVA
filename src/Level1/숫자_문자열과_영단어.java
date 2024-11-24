package Level1;

import java.util.HashMap;
import java.util.Map;

public class 숫자_문자열과_영단어 {
    public int solution(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // 숫자인 경우 결과 문자열에 추가
                result.append(ch);
            } else {
                // 문자인 경우 임시 문자열에 추가
                temp.append(ch);
                // 임시 문자열이 map의 키와 일치하면 변환
                if (map.containsKey(temp.toString())) {
                    result.append(map.get(temp.toString()));
                    temp.setLength(0); // 임시 문자열 초기화
                }
            }
        }

        return Integer.parseInt(result.toString());
    }
}
