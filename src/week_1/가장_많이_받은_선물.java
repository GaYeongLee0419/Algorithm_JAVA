package week_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 선물 지수 = 이번 달까지 자신이 친구들에게 준 선물의 수 - 받은 선물의 수
// 선물을 가장 많이 받을 친구가 받을 선물의 수를 리턴
public class 가장_많이_받은_선물 {
    class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;

            // 각 이름을 번호로 해시
            Map<String, Integer> map = new HashMap<>();
            for ( int i = 0; i < friends.length; i++ )
                map.put(friends[i], i);

            // 주고받은 선물 기록
            int[][] giftArray = new int[friends.length][friends.length];
            // 개인 선물 지수
            int[] resultArray = new int[friends.length];


            for ( String gift : gifts ) {
                String[] list = gift.split(" ");

                giftArray[map.get(list[0])][map.get(list[1])]++;
                resultArray[map.get(list[0])]++;
                resultArray[map.get(list[1])]--;
            }

            // 이번 달 받을 선물 개수가 높은 사람 구하기
            for ( int i = 0; i < resultArray.length; i++ ) {
                //받을 선물
                int count = 0;

                for (int j = 0; j < giftArray.length; j++) {
                    if ( i == j ) continue;
                    // 두 사람이 선물을 주고받은 기록이 있다면 더 많은 선물을 준 사람이 선물을 받음
                    if ( giftArray[i][j] > giftArray[j][i] ) count++;
                    // 주고받은 선물 개수가 같을 때 선물 지수가 더 높은 사람이 선물을 받음
                    else if ( giftArray[i][j] == giftArray[j][i] && resultArray[i] > resultArray[j] ) count++;

                    if ( answer < count ) answer = count;
                }
            }


            return answer;
        }
    }
}
