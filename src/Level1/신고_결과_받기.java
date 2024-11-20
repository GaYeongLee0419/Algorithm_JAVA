package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> map = new HashMap<>();
        // 유저 이름 인덱스 매핑
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
        }

        // countList[b][a] => b가 a를 신고했는지 여부
        int[][] countList = new int[id_list.length][id_list.length];

        // 신고 처리
        for (String report : reports) {
            String[] data = report.split(" ");
            int reporterIndex = map.get(data[0]);  // 신고자 인덱스
            int reportedIndex = map.get(data[1]);  // 신고대상 인덱스

            // 이미 신고한 경우는 건너뛰기
            if (countList[reportedIndex][reporterIndex] == 0) {
                countList[reportedIndex][reporterIndex] = 1;  // 신고한 사람 기록
            }

        }

        for (int[] count : countList) {
           if (Arrays.stream(count).sum() >= k) {
               for (int i = 0; i < id_list.length; i++) {
                   if (count[i] != 0) // 신고한 사람
                       answer[i]++;
               }
           }
        }

        return answer;
    }
    public static void main(String[] args) {
        // 주어진 입력값
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] reports = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        // Solution 객체 생성
        신고_결과_받기 solution = new 신고_결과_받기();

        // solution 메서드 호출
        int[] result = solution.solution(id_list, reports, k);

        // 결과 출력
        System.out.println(Arrays.toString(result)); // [2, 1, 1, 0]
    }

}
