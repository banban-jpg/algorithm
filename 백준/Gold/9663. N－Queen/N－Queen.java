import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        solve(0, 0, 0, 0);

        System.out.println(count);
    }

    /**
     * @param row   현재 행
     * @param col   열 사용 상태
     * @param diag1 / 대각선 사용 상태
     * @param diag2 \ 대각선 사용 상태
     */
    static void solve(int row, int col, int diag1, int diag2) {
        if (row == N) {
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {
            int colBit = 1 << c;
            int diag1Bit = 1 << (row + c);
            int diag2Bit = 1 << (row - c + N - 1);

            if ((col & colBit) != 0) continue;
            if ((diag1 & diag1Bit) != 0) continue;
            if ((diag2 & diag2Bit) != 0) continue;

            solve(
                row + 1,
                col | colBit,
                diag1 | diag1Bit,
                diag2 | diag2Bit
            );
        }
    }
}
