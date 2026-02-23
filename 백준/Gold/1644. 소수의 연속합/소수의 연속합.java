import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 소수 리스트 생성
        boolean[] isPrime = new boolean[N + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= N; p++) {
            if (isPrime[p]) {
                for (int j = p * p; j <= N; j += p) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < primes.size()) {
            sum += primes.get(right++);
            while (sum > N && left < right) {
                sum -= primes.get(left++);
            }
            if (sum == N) {
                count++;
            }
        }

        System.out.println(count);
    }
}