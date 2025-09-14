import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int MAX_N = 40;

        int[] count0 = new int[MAX_N + 1];
        int[] count1 = new int[MAX_N + 1];

        count0[0] = 1; count1[0] = 0;
        count0[1] = 0; count1[1] = 1;

        for (int i = 2; i <= MAX_N; i++) {
            count0[i] = count0[i - 1] + count0[i - 2];
            count1[i] = count1[i - 1] + count1[i - 2];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(count0[N]).append(" ").append(count1[N]).append("\n");
        }

        System.out.print(sb);
    }
}
