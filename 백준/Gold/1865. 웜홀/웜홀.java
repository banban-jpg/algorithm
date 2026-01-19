import java.io.*;
import java.util.*;

public class Main {

    static int[] from, to, cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine().trim());

        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int E = 2 * M + W; // 전체 간선 수
            from = new int[E];
            to = new int[E];
            cost = new int[E];

            int idx = 0;

            // 도로 양방향
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                from[idx] = S;
                to[idx] = T;
                cost[idx] = C;
                idx++;

                from[idx] = T;
                to[idx] = S;
                cost[idx] = C;
                idx++;
            }

            // 웜홀 단방향
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                from[idx] = S;
                to[idx] = T;
                cost[idx] = -C;
                idx++;
            }

            if (hasNegativeCycle(N, E)) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb.toString());
    }

    static boolean hasNegativeCycle(int N, int E) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, 0);

        for (int i = 1; i <= N; i++) {
            boolean updated = false;

            for (int j = 0; j < E; j++) {
                int u = from[j];
                int v = to[j];
                int w = cost[j];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    updated = true;

                    if (i == N) return true; // 음수 사이클
                }
            }

            if (!updated) break;
        }

        return false;
    }
}
