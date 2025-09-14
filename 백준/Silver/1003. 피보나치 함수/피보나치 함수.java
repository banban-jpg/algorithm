import java.util.Scanner;

public class Main {

    private static final int MAX_N = 40;
    private static int[] count0 = new int[MAX_N + 1];
    private static int[] count1 = new int[MAX_N + 1];

    // 정적 초기화 블록: 프로그램 실행 시 0과 1의 출력 횟수를 미리 계산
    static {
        count0[0] = 1;
        count1[0] = 0;
        count0[1] = 0;
        count1[1] = 1;

        // 동적 프로그래밍을 통해 각 N에 대한 0과 1의 출력 횟수를 미리 계산
        for (int i = 2; i <= MAX_N; i++) {
            count0[i] = count0[i - 1] + count0[i - 2];
            count1[i] = count1[i - 1] + count1[i - 2];
        }
    }

    // 특정 N에 대해 0과 1의 출력 횟수를 반환하는 메서드
    public static int[] getFibonacciCounts(int n) {
        if (n < 0 || n > MAX_N) {
            throw new IllegalArgumentException("N should be between 0 and " + MAX_N);
        }
        return new int[]{count0[n], count1[n]};
    }

    // main 메서드: 프로그램 실행의 진입점
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] result = getFibonacciCounts(N);
            System.out.println(result[0] + " " + result[1]);
        }

        scanner.close();
    }
}
