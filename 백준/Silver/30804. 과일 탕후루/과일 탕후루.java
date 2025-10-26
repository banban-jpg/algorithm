import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

 
        int[] count = new int[10];
        int kind = 0; // 현재 구간 내 과일
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < N; right++) {
            int fruit = fruits[right];

            // 새로운 과일
            if (count[fruit] == 0) kind++;
            count[fruit]++;

            //3개 이상이면 왼쪽 포인터 이동
            while (kind > 2) {
                int leftFruit = fruits[left];
                count[leftFruit]--;
                if (count[leftFruit] == 0) kind--;
                left++;
            }

            
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}
