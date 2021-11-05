package recursion;

/**
 * Created by Minho Park on 2021-11-04.
 *
 * 상태 공간 트리
 * 즉 해가 존재한다면 그것은 반드시 이 트리의 어떤 한 노드에 해당함
 * 따라서 이 트리를 체계적으로 탐색하면 해를 구할 수 있음
 */
public class NQueens {
    public static void main(String[] args) {
        queens(1);
    }

    // Backtracking : DFS
    /**
     * @param level : 현재 노드의 위치(0 부터 시작)
     * @return
     */
    public static final int N = 4;
    public static int[] cols = new int[N + 1];
    public static boolean queens(int level) {
        if (!promising(level)) {
            return false;
        } else if (level == N) {    // 모든 말이 놓였다
            for (int i = 1; i <= N; i++) {
                System.out.println("(" + i + "," + cols[i] + ")");
            }
            return true;
        }
        // level+1 번째 말을 각각의 열에 놓은 후 recursion 을 호충한다
        for (int i = 1; i <= N; i++) {
            cols[level + 1] = i;
            if (queens(level + 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean promising(int level) {
        for (int i = 1; i <= level; i++) {
            if (cols[i] == cols[level]) // 같은 열에 놓였는지 검사
                return false;
            else if (level - i == Math.abs(cols[level] - cols[i])) // 같은 대각선에 놓였는지 검사, 거리 비교
                return false;
        }

        return true;
    }
}
