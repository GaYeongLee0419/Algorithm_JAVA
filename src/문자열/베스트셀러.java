package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 베스트셀러 {
    public static String solution(String[] books) {
        Map<String, Integer> map = new HashMap<>();

        for (String book : books) {
            if (map.containsKey(book)) map.put(book, map.get(book) + 1);
            else map.put(book, 1);
        }

        String[] keys = map.keySet().toArray(new String[map.size()]);

        Arrays.sort(keys, (a, b) -> {
            if (map.get(a) > map.get(b)) return 1;
            else if (map.get(a) == map.get(b)) return b.compareTo(a);
            else return -1;
        });

        return keys[keys.length - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] books = new String[n];
        for (int i = 0; i < n; i++) {
            books[i] = br.readLine();
        }
        System.out.println(solution(books));
    }
}
