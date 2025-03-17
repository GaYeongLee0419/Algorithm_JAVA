package Hash;

import java.util.HashMap;

public class Pocketmon {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int choice = nums.length / 2;

        if (map.size() >= choice) return choice;

        return map.size();
    }
}
