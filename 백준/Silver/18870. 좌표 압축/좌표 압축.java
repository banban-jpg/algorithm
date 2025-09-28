import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // 중복 제거
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int x : sorted) {
            if (!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }


        for (int x : arr) {
            sb.append(map.get(x)).append(' ');
        }

        System.out.println(sb);
    }
}
