package Level1;

public class 크기가_작은_부분_문자열 {
    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length()-p.length(); i++) {
            if (Long.valueOf(t.substring(i, i+p.length())) <= Long.valueOf(p)) {
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        크기가_작은_부분_문자열 sol = new 크기가_작은_부분_문자열();
        System.out.println(sol.solution("500220839878", "7"));
    }
}
