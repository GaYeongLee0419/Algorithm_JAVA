package Level1;

public class 푸드_파이트_대회 {
    public String solution(int[] food) {
        String answer = "";
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < (int)food[i] / 2; j++) {
                sb.append(i);
            }
        }

        answer = sb.toString() + '0';
        answer = answer + sb.reverse().toString();

        return answer;
    }

    public static void main(String[] args) {
        푸드_파이트_대회 sol = new 푸드_파이트_대회();

        System.out.println(sol.solution(new int[]{1,3,4,6}));
    }
}
