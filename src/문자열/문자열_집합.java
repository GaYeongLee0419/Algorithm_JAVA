package 문자열;

import java.util.*;

public class 문자열_집합 {
    public int solution(List<String> set, List<String>  find){
        Map<String, Integer> map = new HashMap<>();
        for (String s : set) {
            map.put(s, 1);
        }

        int count = 0;
        for (String s : find) {
            if (map.containsKey(s)) count++;
        }

        return count;
    }

    public static int solution2(List<String> set, List<String> find) {
        Set<String> keys = new HashSet<>(set);
        for (String s : set) {
            keys.add(s);
        }
        int count = 0;
        for (String s : find) {
            if (keys.contains(s)) count++;
        }

        return count;
    }

    public static void main(String args[]) {
        문자열_집합 sol = new 문자열_집합();

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        String[] numbers = num.split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);

        List<String> set = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextLine());
        }

        List<String> find = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            find.add(sc.nextLine());
        }

        System.out.println(sol.solution(set, find));
    }
}
