package Greedy;

public class JoyStick {
    public int solution(String name) {
        int minSwitchCount = 0;
        for (char c : name.toCharArray()) {
            minSwitchCount += getMinSwitchCount(c);
        }

        return minSwitchCount + getMinMoveCount(name.length(), name);
    }

    private int getMinSwitchCount(char c) {
        return Math.min(c - 'A', 'Z' - c + 1);
    }

    private int getMinMoveCount(int length, String name) {
        int result = length - 1; //기본은 왼쪽에서 오른쪽으로 끝까지 이동

        for (int i = 0 ; i < length; i++) {
            int next = i + 1;

            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            // i : 오른쪽으로 간 거리 , next : 연속된 A 다음에 있는 다시 처리해야 할 위치
            //오른쪽 -> 왼쪽
            int move = i * 2 + (length - next);
            //왼쪽 -> 오른쪽
            int reverseMove = (length - next) * 2 + i;

            result = Math.min(result, Math.min(move, reverseMove));
        }

        return result;
    }

    public static void main(String[] args) {
        JoyStick js = new JoyStick();
        System.out.println(js.solution("JEROEN")); // 기대값: 56
        System.out.println(js.solution("JAN"));    // 기대값: 23
    }
}
