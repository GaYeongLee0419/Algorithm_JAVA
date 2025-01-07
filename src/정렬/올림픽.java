package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class 올림픽 {
    public static void solution(List<String> data, int number) {
        Map<Integer, Integer> map = new HashMap<>();

        for (String info : data) {
            String[] temp = info.split(" ");
            int country = Integer.parseInt(temp[0]);
            int gold = Integer.parseInt(temp[1]);
            int silver = Integer.parseInt(temp[2]);
            int bronze = Integer.parseInt(temp[3]);

            int total = (gold * 3) + (silver * 2) + (bronze * 1);

            map.put(country, total);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        int beforeKey = entryList.get(0).getKey();
        int beforeValue = entryList.get(0).getValue();
        int count = 1;
        if (beforeKey == number) {
            System.out.println(count);
            return;
        }

        for (int i = 1; i < entryList.size(); i++) {
            if (entryList.get(i).getValue() != beforeValue) {
                count++;
            }
            if (entryList.get(i).getKey() == number) {
                System.out.println(count);
                return;
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().toString().split(" ");

        List<String> data = new ArrayList<>();

        for (int i = 0; i < Integer.parseInt(nums[0]); i++) {
            data.add(br.readLine());
        }

        solution(data, Integer.parseInt(nums[1]));
    }
}
