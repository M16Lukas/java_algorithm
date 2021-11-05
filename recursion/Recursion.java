package recursion;

/**
 * Created by Minho Park on 2021-11-02.
 */
public class Recursion {
    public static void main(String[] args) {
        int result = func(4);
        System.out.println(result);
    }

    public static int func(int k){
        // Base case : 적어도 하나의 recursion 에 빠지지 않는 경우가 존재해야함
        if (k <= 0) {
            return 0;
        } else {
            // recursion Case : recursion 을 반복하다보면 결국 base case 로 수렴해야 한다
            return k + func(k-1);
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n - 1);
        }
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // 최대공약수 : Euclid Method
    /**
     * m >= n 인 두 양수 m, n에 대해서 m이 n의 배수이면 gcd(m,n) = n.
     * 그렇지 않으면 gcd(m,n) = gcd(n, m%n)
     *
     * @param m
     * @param n
     */
    public static double gcd1(int m, int n) {
        if (m < n) {
            // swap m and n
            int tmp = m;
            m = n;
            n = tmp;
        }
        if (m % n == 0) {
            return n;
        } else {
            return gcd1(n, m % n);
        }
    }

    public static double gcd2(int m, int n) {
        if (n == 0) {
            return n;
        } else {
            return gcd1(n, m % n);
        }
    }
}
