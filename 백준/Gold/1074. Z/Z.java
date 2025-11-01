import java.io.*;
import java.util.*;

public class Main {

    static int count = 0; // 방문 순서
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(findZ(N, r, c));
    }

    private static int findZ(int n, int row, int col) {
        if (n == 0) return 0; // 1x1 크기면 0번째 방문

        int half = 1 << (n - 1); // 2^(n-1)
        int area = half * half;  // 한 사분면 크기

        // 사분면 판별
        if (row < half && col < half) {
            // 1사분면 
            return findZ(n - 1, row, col);
        }
        if (row < half && col >= half) {
            // 2사분면 
            return area + findZ(n - 1, row, col - half);
        }
        if (row >= half && col < half) {
            // 3사분면 
            return 2 * area + findZ(n - 1, row - half, col);
        }
        // 4사분면 
        return 3 * area + findZ(n - 1, row - half, col - half);
    }
}
