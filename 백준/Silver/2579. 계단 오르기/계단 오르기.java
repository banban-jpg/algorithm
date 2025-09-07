import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 계단 개수

        int[] stair = new int[n + 1]; 
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

       
        dp[0] = 0;
        dp[1] = stair[1];

        if (n >= 2) {
            dp[2] = stair[1] + stair[2]; // 첫 번째, 두 번째 계단 밟는 경우
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
        }

        System.out.println(dp[n]);
    }
}
