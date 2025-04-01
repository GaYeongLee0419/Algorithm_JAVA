package Greedy;

import java.util.Arrays;

public class Boat {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0, right = people.length - 1;
        int result = 0;
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }

            result++;
        }

        if (left == right) result++;

        return result;
    }

    public static void main(String[] args) {
        Boat boat = new Boat();
        System.out.println(boat.solution(new int[] {70, 50, 80, 50}, 3));
    }
}
