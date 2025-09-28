import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무 개수
        long M = Long.parseLong(st.nextToken());  // 나무 길이

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());

        int maxTree = 0; // 가장 높은 나무
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > maxTree) maxTree = trees[i];
        }

        int left = 0;
        int right = maxTree;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long wood = 0;

            // 잘린 나무 길이 계산
            for (int h : trees) {
                if (h > mid) {
                    wood += (h - mid);
                }
            }

            if (wood >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
