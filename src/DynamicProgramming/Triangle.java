package DynamicProgramming;

public class Triangle {
    // 대각선 왼쪽, 대각선 오른쪽
    public static int[][] moves = {{-1, 0}, {-1, -1}};

    public int solution(int[][] triangle) {
        int row = triangle.length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i + 1; j++) {
                int max = 0;
                for (int[] move : moves) {
                    int nx = i + move[0];
                    int ny = j + move[1];

                    if (nx >= 0 && ny >= 0 && ny < triangle[i].length - 1) {
                        max = Math.max(max, triangle[nx][ny]);
                    }
                }
                triangle[i][j] += max;
            }
        }

        int result = 0;
        for (int sum : triangle[row - 1]) {
            result = Math.max(result, sum);
        }

        return result;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        int[][] input = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        int result = triangle.solution(input);
        System.out.println(result);
    }
}
