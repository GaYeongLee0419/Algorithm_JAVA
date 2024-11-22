package Level1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class 개인정보_수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer =new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            map.put(term[0], Integer.valueOf(term[1]));
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate now = LocalDate.parse(today, formatter);

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            LocalDate date = LocalDate.parse(privacy[0], formatter);
            date = date.plusMonths(map.get(privacy[1]));

            System.out.printf("today : %s date : %s\n", now, date);
            if (date.isBefore(now) || date.isEqual(now)) {
                answer.add(i + 1);
                System.out.printf("today : %s date : %s today is after date" , now, date);
            }
        }

        answer.sort(Integer::compareTo);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
