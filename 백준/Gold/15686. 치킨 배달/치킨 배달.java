import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) houses.add(new int[]{i, j});
                else if (val == 2) chickens.add(new int[]{i, j});
            }
        }

        selected = new boolean[chickens.size()];
        combination(0, 0);
        System.out.println(answer);
    }

    // 조합으로 M개의 치킨집 선택
    static void combination(int start, int count) {
        if (count == M) {
            calculateDistance();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            combination(i + 1, count + 1);
            selected[i] = false;
        }
    }

    // 선택된 치킨집으로부터 모든 집의 최소 거리 합 계산
    static void calculateDistance() {
        int total = 0;

        for (int[] house : houses) {
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i < chickens.size(); i++) {
                if (!selected[i]) continue;

                int[] chicken = chickens.get(i);
                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDist = Math.min(minDist, dist);
            }

            total += minDist;
        }

        answer = Math.min(answer, total);
    }
}
