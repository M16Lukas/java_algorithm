package recursion;

/**
 * Created by Minho Park on 2021-11-03.
 *
 * 미로찾기
 * 입구 : (0, 0), 출구 : (n-1, n-1)
 *
 */
public class Maze {

    private static int N = 8;
    private static int[][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0},
    };

    private static final int PATHWAY_COLOR = 0; // white
    private static final int WALL_COLOR = 1;    // blue

    // visited 이며 출구까지의 경로상에 있지 않음이 밝혀진 cell
    private static final int BLOCKED_COLOR = 2; // red

    // visited 이며 아직 출구로 가는 경로가 될 가능성이 있는 cell
    private static final int PATH_COLOR = 3;    // green

    public static void main(String[] args) {
        printMaze();
        findPath(0, 0);
        printMaze();
    }

    private static void printMaze() {
        for (int[] mz : maze) {
            for(int i : mz){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 미로 찾기(Decision Problem) : 답이 Yes or No 인 문제
    /* 현재 위치에서 출구까지 가는 경로가 있으려면
     * 1) 현재 위치가 출구이거나
     * 2) 이웃한 셀들 중 하나에서 현재 위치를 지나지 않고 출구까지 가는 경로가 있거나
    */
    public static boolean findPath(int x, int y) {
        // 미로의 범위를 넘어서는 경우
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }
        // 이미 방문한 위치(visited)이거나 벽(wall)인 경우
        else if (maze[x][y] != PATHWAY_COLOR) {
            return false;
        }
        // 출구인 경우
        else if (x == N-1 && y == N-1) {
            maze[x][y] = PATH_COLOR;
            return true;
        } else {
            maze[x][y] = PATH_COLOR;
            if (findPath(x - 1, y) || findPath(x + 1, y) || findPath(x, y - 1) ||
                    findPath(x, y + 1)) {
                return true;
            }
            maze[x][y] = BLOCKED_COLOR; // dead end
            return false;
        }
    }
}
