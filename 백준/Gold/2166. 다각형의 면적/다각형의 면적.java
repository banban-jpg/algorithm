import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] x, y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        x = new long[N];
        y = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        double area = getArea(N);
        System.out.printf("%.1f\n", area);
    }

    // 신발끈 공식
    static double getArea(int N) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N;   // 다음 점, 마지막은 첫 점으로 연결
            sum += x[i] * y[j] - x[j] * y[i];
        }

        return Math.abs(sum) / 2.0;
    }
}
