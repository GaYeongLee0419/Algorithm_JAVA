package Level1;

import java.util.Arrays;

public class 지폐_접기 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        Arrays.sort(wallet);
        Arrays.sort(bill);
        while (true) {
            if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) break;
            else {
                bill[1] = (int)bill[1] / 2;
                Arrays.sort(bill);
                answer++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        지폐_접기 sol = new 지폐_접기();

        System.out.println(sol.solution(new int[] {50, 50}, new int[] {100, 241}));
    }
}
