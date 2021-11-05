package recursion;

/**
 * Created by Minho Park on 2021-11-05.
 *
 * 멱집합(PowerSet)
 * 임의의 집합 data 의 모든 부분집합을 출력하라.
 */
public class PowerSet {
    public static void main(String[] args) {
        powerSet(0);
    }

    private static final char[] data = {'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int n = data.length;
    // 트리상에서 현재 나의 위치를 표현한다
    private static boolean[] include = new boolean[n];

    /**
     * 상태 공간 트리(state space tree)
     * - 해를 찾기 위해 탐색할 필요가 있는 모든 후보들을 포함하는 트리
     * - 트리의 모든 노드들을 방문하면 해를 찾을 수 있다.
     * - 루트를 출발하여 체계적으로 모든 노드를 방문하는 절차를 기술한다
     * @param k : 트리상에서 현재 나의 위치를 표현한다
     */
    public static void powerSet(int k) {
        /*
         * 만약 내 위치가 리프 노드라면
         * data[k] ~ data[n-1] 의 멱집합을 구한 후 각각에 include[i] = true,
         * i=0,...,k-1, 인 원소를 추가하여 출력하라.
         */
        if (k == n) {
            for (int i = 0; i < n; i++) {
                if (include[i]) System.out.print(data[i] + " ");
            }
            System.out.println();
            return;
        }
        /*
         * data[k]를 포함하지 않는 경우,
         * 먼저 왼쪽으로 내려간다
         */
        include[k] = false;
        powerSet(k + 1);
        /*
         * data[k]를 포함하는 경우,
         * 이번에는 오른쪽으로 내려간다
         */
        include[k] = true;
        powerSet(k + 1);

    }
}
