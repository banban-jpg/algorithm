import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] maxDP = new int[3];
        int[] minDP = new int[3];

        // 첫 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int val = Integer.parseInt(st.nextToken());
            maxDP[i] = val;
            minDP[i] = val;
        }

        // 2번째 줄부터 N번째 줄까지 처리
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            maxDP = getNextMax(maxDP, a, b, c);
            minDP = getNextMin(minDP, a, b, c);
        }

        int maxAns = Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2]));
        int minAns = Math.min(minDP[0], Math.min(minDP[1], minDP[2]));

        System.out.println(maxAns + " " + minAns);
    }

    //max DP 계산
    private static int[] getNextMax(int[] prev, int a, int b, int c) {
        int[] next = new int[3];
        next[0] = Math.max(prev[0], prev[1]) + a;
        next[1] = Math.max(Math.max(prev[0], prev[1]), prev[2]) + b;
        next[2] = Math.max(prev[1], prev[2]) + c;
        return next;
    }

    // min DP 계산
    private static int[] getNextMin(int[] prev, int a, int b, int c) {
        int[] next = new int[3];
        next[0] = Math.min(prev[0], prev[1]) + a;
        next[1] = Math.min(Math.min(prev[0], prev[1]), prev[2]) + b;
        next[2] = Math.min(prev[1], prev[2]) + c;
        return next;
    }
}
