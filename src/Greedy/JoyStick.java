package Greedy;

public class JoyStick {
    public int solution(String name) {
        int moveCount = 0;
        int minMove = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {

            char c = name.charAt(i);
            moveCount += Math.min(c - 'A', 'Z' - c + 1);

            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            minMove = Math.min(minMove, (i * 2) + (name.length() - next));
            minMove = Math.min(minMove, (name.length() - next) * 2 + i);
        }

        return moveCount + minMove;
    }

    public static void main(String[] args) {
        JoyStick js = new JoyStick();
        System.out.println(js.solution("JEROEN"));
        System.out.println(js.solution("JAN"));
    }
}
