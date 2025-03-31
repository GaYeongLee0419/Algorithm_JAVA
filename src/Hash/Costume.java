package Hash;

import java.util.HashMap;
import java.util.Map;

public class Costume {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        int result = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result *= (entry.getValue() + 1);
        }

        return result - 1;
    }

    public static void main(String[] args) {
        Costume costume = new Costume();
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };


        System.out.println(costume.solution(clothes));
    }
}
