package 문자열;
import java.util.*;

public class 균형잡힌_세상 {
    private String solution(String s) {
        List<String> stack = new ArrayList<>();
        String answer = "yes";
        for (int i = 0; i < s.length(); i++) {
            String now = s.substring(i, i + 1);
            if (now.equals("(") || now.equals("[")) stack.add(now);
            else if (now.equals(")") || now.equals("]")) {
                if (stack.isEmpty()) return "no";
                String pop = stack.remove(stack.size() - 1);
                if ((pop.equals("(") && now.equals("]")) || (pop.equals("[") && now.equals(")"))) return "no";
            }
            else continue;
        }

        return answer;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        균형잡힌_세상 sol = new 균형잡힌_세상();

        while (true) {
            String s = sc.nextLine();
            System.out.println(sol.solution(s));
            if (s.equals(".")) break;
        }

//        System.out.println(sol.solution("So when I die (the [first] I will see in (heaven) is a score list)."));
//        System.out.println(sol.solution("[ first in ] ( first out )."));
//        System.out.println(sol.solution("Half Moon tonight (At least it is better than no Moon at all]."));
//        System.out.println(sol.solution("A rope may form )( a trail in a maze."));
//        System.out.println(sol.solution("Help( I[m being held prisoner in a fortune cookie factory)]."));
//        System.out.println(sol.solution("([ (([( [ ] ) ( ) (( ))] )) ])."));
//        System.out.println(sol.solution("."));

    }

}
