package recursion;

/**
 * Created by Minho Park on 2021-11-02.
 * 순환 알고리즘의 설계
 *
 * 적어도 하나의 base case, 즉 순환되지 않고 종료되는 case 가 있어야 함
 * 모든 case 는 결국 base case 로 수렴해야 함
 *
 * 암시적(implicit) 매개변수를 명시적(explicit) 매개변수로 비꾸어라
 */
public class DesigningRecursion {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 6, 7};
        System.out.println(search1(data, data.length, 6));
    }

    // 순차 탐색 1
    // 검색 구간의 시작 인덱스 0은 보통 생략한다. 즉, "암시적 매개변수"이다
    public static int search1(int[] data, int n, int target) {
        for (int i = 0; i < n; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 순차 탐색 2
    // 매개 변수의 명시화
    // data[begin]에서 data[end] 사이에서 target 을 검색한다
    public static int search2(int[] data, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        } else if (target == data[begin]) {
            return begin;
        } else {
            return search2(data, begin + 1, end, target);
        }
    }

    // 최대값 찾기
    public static int findMax(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        } else {
            return Math.max(data[begin], findMax(data, begin + 1, end));
        }
    }

    // binary search
    public static int binarySearch(String[] items, String target, int begin, int end) {
        if (begin > end) {
            return -1;
        } else {
            int middle = (begin + end) / 2;
            int compResult = target.compareTo(items[middle]);
            if (compResult == 0){
                return middle;
            } else if (compResult < 0) {
                return binarySearch(items, target, begin, middle - 1);
            } else {
                return binarySearch(items, target, middle + 1, end);
            }
        }
    }
}
