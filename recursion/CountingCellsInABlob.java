package recursion;

/**
 * Created by Minho Park on 2021-11-03.
 *
 * Binary image
 * 각 픽셀은 background pixel 이거나 혹은 image pixel
 * 서로 연결된 image pixel 들의 집합을 blob 이라고 부름
 * 상하좌우 및 대각방향으로도 연결된 것으로 간주
 */
public class CountingCellsInABlob {
    /*
     * 입력 :
     * - n * n 크기의 2차원 그리드
     * - 하나의 좌표(x, y)
     *
     * 출력 :
     * - 픽셀 (x, y)가 포함된 blob 의 크기
     * - (x, y)가 어떤 Blob 에도 속하지 않는 경우에는 0
     */
    public static int N = 8;
    public static int[][] grids = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 1}
    };

    private static final int BACKGROUND_COLOR = 0;
    private static final int IMAGE_COLOR = 1;
    private static final int ALREADY_COUNTED = 2;

    public static int countCells(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return 0;
        } else if (grids[x][y] != IMAGE_COLOR) {
            return 0;
        } else {
            grids[x][y] = ALREADY_COUNTED;
            return 1 + countCells(x-1,y+1) + countCells(x,y+1)
                    + countCells(x+1,y+1) + countCells(x-1,y)
                    + countCells(x+1,y) + countCells(x-1,y-1)
                    + countCells(x,y-1) + countCells(x+1,y-1);
        }
    }

    public static void main(String[] args) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (grids[x][y] == 1)
                    System.out.println(countCells(x, y));
            }
        }
    }
}
