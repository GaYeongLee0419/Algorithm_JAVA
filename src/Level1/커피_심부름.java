package Level1;

import java.util.HashMap;
import java.util.Map;

public class 커피_심부름 {
    public int solution(String[] order) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("americano", 4500);
        map.put("cafelatte", 5000);
        map.put("anything", 4500);
        map.put("iceamericano", 4500);
        map.put("hotamericano", 4500);
        map.put("americanoice", 4500);
        map.put("americanohot", 4500);
        map.put("icecafelatte", 5000);
        map.put("hotcafelatte", 5000);
        map.put("cafelatteice", 5000);
        map.put("cafelattehot", 5000);

        for (String o: order) {
            answer += map.get(o);
        }
        return answer;
    }
}
