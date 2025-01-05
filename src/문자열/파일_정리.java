package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 파일_정리 {

    public static void solution(String[] files) {
        Map<String, Integer> map = new HashMap<>();

        for (String file : files) {
            String[] split = file.split("\\.");
            String extension = split[1];

            if (!map.containsKey(extension)) map.put(extension, 1);
            else map.put(extension, map.get(extension) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort(Map.Entry.comparingByKey());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entryList) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(sb);


    }

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] files = new String[n];

        for (int i = 0; i < n; i++) files[i] = br.readLine();

        solution(files);
    }
}
