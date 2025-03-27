package Sort;

import java.util.Arrays;
//0 1 3 5 6
public class H_Index {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations.length - i  == citations[i])
                h = citations[i];
        }

        return h;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        H_Index hIndex = new H_Index();
        System.out.println(hIndex.solution(citations));
    }
}
