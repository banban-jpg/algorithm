import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long[] answer = findClosestToZero(N);

        System.out.println(answer[0] + " " + answer[1]);
    }

    // 0에 가장 가까운 조합 찾기
    static long[] findClosestToZero(int N) {
        int left = 0;
        int right = N - 1;

        long bestSum = Long.MAX_VALUE;
        long v1 = 0, v2 = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(bestSum)) {
                bestSum = sum;
                v1 = arr[left];
                v2 = arr[right];
            }

            if (sum > 0) right--;      
            else left++;               
        }

        return new long[]{v1, v2};
    }
}
