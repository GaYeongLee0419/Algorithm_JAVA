package Level1;

public class 붕대감기 {
    // bandage = [ 시전 시간, 초당 회복량, 추가 회복량 ]
    // t초 동안 붕대를 감으면 1초마다 x 만큼의 체력을 회복
    // t초 연속으로 붕대를 감는 데 성공한다면 y 만큼의 체력을 추가로 회복
    // 기술을 쓰는 도중 공격을 당하면 기술 취소 & 체력 회복 불가
    // 공격이 끝난 뒤 붕대 감기 다시 사용하며, 연속 성공 시간이 0으로 초과
    static class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int MAX = health;
            int time = 0; // 현재 시간
            int maintain = 0; // 연속 시간

            for ( int[] attack : attacks ) {
                maintain = 0;
                while ( time < attack[0] ) {
                    time ++;
                    // 체력 회복
                    if ( time != attack[0] ) {
                        health += bandage[1];
                        maintain ++;
                        // 추가 회복
                        if ( maintain == bandage[0] ) {
                            health += bandage[2];
                            maintain = 0;
                        }

                        if ( health > MAX ) health = MAX;
                    }
                    // 공격
                    else if ( time == attack[0]) {
                        health -= attack[1];
                    }

                    System.out.printf("time : %d | maintain : %d | health : %d\n", time, maintain, health);

                    //체력이 0 이하일 때
                    if ( health <= 0 ) {
                        return -1;
                    }
                }
            }
            return health;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {
                {2, 10}, {9, 15}, {10, 5}, {11, 5}
        };

        System.out.println(solution.solution(bandage, health, attacks));

    }
}
