package week_1;

import java.util.ArrayList;
import java.util.Collections;
public class 문자열_내_마음대로_정렬하기 {
    class Solution {
        public String[] solution(String[] strings, int n) {
            String[] answer = new String[strings.length];
            ArrayList<String> arr = new ArrayList<>();

            for (int i = 0; i < strings.length; i++) {
                arr.add(strings[i].substring(n, n+1) + strings[i]);
            }

            Collections.sort(arr);

            for (int i = 0; i < arr.size(); i++) {
                answer[i] = arr.get(i).substring(1, arr.get(i).length());
            }

            return answer;
        }
    }
}
