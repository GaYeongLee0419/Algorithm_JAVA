package Level1;

import java.util.*;
import java.util.stream.Collectors;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        int people = stages.length;
        List<Integer> stageList = Arrays.stream(stages).boxed().collect(Collectors.toList());

        for (int i = 1; i < N+1; i++ ) {
            int count = Collections.frequency(stageList, i);
            double failure = 0;

            if (people != 0) failure = (double)count / people;

            people -= count;
            map.put(i, failure);
        }

        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((key1, key2) -> Double.compare(key2.getValue(), key1.getValue()));

        return entryList.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}
