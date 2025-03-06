package BFS;

import java.util.*;

public class Puzzle {
}

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        List<List<Point>> emptySpace = findShapes(game_board, 0);
        List<List<Point>> blocks = findShapes(table, 1);

        return match(emptySpace, blocks);
    }

    public List<List<Point>> findShapes(int[][] board, int value) {
        int n = board.length;
        List<List<Point>> shapes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == value) {
                    shapes.add(bfs(board, i, j, value));
                }
            }
        }

        return shapes;
    }

    private List<Point> bfs(int[][] board, int x, int y, int value) {
        int n = board.length;
        Queue<Point> queue = new LinkedList<>();
        List<Point> coords = new ArrayList<>();
        queue.offer(new Point(x, y));
        board[x][y] = -1;
        coords.add(new Point(0, 0));

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int cx = current.x;
            int cy = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isInArea(nx, ny, n) && board[nx][ny] == value) {
                    board[nx][ny] = -1;
                    queue.offer(new Point(nx, ny));
                    coords.add(new Point(nx - x, ny - y));
                }
            }
        }

        return normalize(coords);
    }

    private boolean isInArea(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private List<Point> normalize(List<Point> coords) {
        if (coords.isEmpty()) return coords;

        int minX = coords.stream().mapToInt(p -> p.x).min().orElse(0);
        int minY = coords.stream().mapToInt(p -> p.y).min().orElse(0);

        for (Point coord : coords) {
            coord.x -= minX;
            coord.y -= minY;
        }

        return coords;
    }

    private int match(List<List<Point>> emptySpace, List<List<Point>> blocks) {
        int result = 0;
        boolean[] visited = new boolean[blocks.size()];

        for (List<Point> space : emptySpace) {
            for (int j = 0; j < blocks.size(); j++) {
                if (visited[j]) continue;

                List<Point> block = blocks.get(j);
                if (compareAndRotate(space, block)) {
                    result += block.size();
                    visited[j] = true;
                    break;
                }
            }
        }
        return result;
    }

    private boolean compareAndRotate(List<Point> space, List<Point> block) {
        if (space.size() != block.size()) return false;

        List<Point> rotated = block;
        for (int i = 0; i < 4; i++) {
            if (compare(space, rotated))
                return true;

            rotated = rotate(rotated);
        }

        return false;
    }

    private List<Point> rotate(List<Point> coords) {
        List<Point> rotated = new ArrayList<>();
        for (Point coord : coords) {
            int nx = coord.y;
            int ny = -coord.x;
            rotated.add(new Point(nx, ny));
        }
        return normalize(rotated);
    }

    private boolean compare(List<Point> space, List<Point> block) {
        space.sort(Comparator.comparingInt((Point p) -> p.x).thenComparingInt(p -> p.y));
        block.sort(Comparator.comparingInt((Point p) -> p.x).thenComparingInt(p -> p.y));

        for (int i = 0; i < space.size(); i++) {
            Point s = space.get(i);
            Point b = block.get(i); // 수정된 부분
            if (s.x != b.x || s.y != b.y) return false;
        }

        return true;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
