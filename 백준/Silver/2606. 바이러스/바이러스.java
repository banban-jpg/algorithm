import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int n; // 컴퓨터 수
    static int m; // 쌍의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        m = Integer.parseInt(br.readLine()); // 쌍의 수

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        int result = dfs(1); // 1번 컴퓨터에서 시작
        System.out.println(result);
    }

    static int dfs(int start) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int i = 1; i <= n; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                    count++; //  감염된 컴퓨터 개수 +
                }
            }
        }
        return count;
    }
}
