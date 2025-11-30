import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] tree;
    static int[] subtree;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        subtree = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        // 서브트리  계산
        dfs(R);

        StringBuilder sb = new StringBuilder();

        // 쿼리 처리
        while (Q-- > 0) {
            int node = Integer.parseInt(br.readLine());
            sb.append(subtree[node]).append("\n");
        }

        System.out.print(sb);
    }

    // DFS
    static int dfs(int now) {
        visited[now] = true;
        int count = 1; // 자기 자신 포함

        for (int next : tree[now]) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }

        subtree[now] = count;
        return count;
    }
}
