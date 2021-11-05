package recursion;

import java.util.Scanner;

/**
 * Created by Minho Park on 2021-11-02.
 * 
 * 순환적으로 사고하기
 */
public class RecursiveThinking {
    public static void main(String[] args) {
        String str = "abcx";
        System.out.println(length(str));
        printChars(str);

        System.out.println();
        printCharsReverse(str);

        System.out.println();
        printInBinary(13);

        int[] data = {1, 4, 3, 2, 4, 5};
        System.out.println("\n" + sum(4, data));
    }

    // 문자열 길이 계산
    public static int length(String str) {
        if (str.equals("")) {
            return 0;
        } else {
            return 1 + length(str.substring(1));
        }
    }

    // 문자열의 프린트
    public static void printChars(String str) {
        if (str.equals("")) {
            return;
        } else {
            System.out.print(str.charAt(0));
            printChars(str.substring(1));
        }
    }

    // 문자열을 뒤집어서 프린트
    public static void printCharsReverse(String str) {
        if (str.length() == 0) {
            return;
        } else {
            printCharsReverse(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    // 2진수로 변환하여 출력
    public static void printInBinary(int n) {
        if (n < 2) {
            System.out.print(n);
        } else {
            printInBinary(n / 2);
            System.out.print(n % 2);
        }
    }

    // 배열의 합 구하기
    public static int sum(int n, int[] data) {
        if (n <= 0) {
            return 0;
        } else {
            return sum(n - 1, data) + data[n - 1];
        }
    }

    // 데이터파일로부터 n개의 정수 읽어오기
    // Scanner in 이 참조하는 파일로부터 n개의 정수를 입력받아 배열 data 의
    // data[0], ... ,data[n-1]에 저장한다.
    public static void readFrom(int n, int[] data, Scanner in) {
        if (n == 0) {
            return;
        } else {
            readFrom(n - 1, data, in);
            data[n - 1] = in.nextInt();
        }
    }
}
