import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static String[] path;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(bfs(A, B)).append("\n");
        }
        System.out.print(sb);
    }

    static String bfs(int start, int target) {
        visited = new boolean[10000];
        path = new String[10000];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        path[start] = "";

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == target) return path[cur];

            int d = D(cur);
            int s = S(cur);
            int l = L(cur);
            int r = R(cur);

            if (!visited[d]) {
                visited[d] = true;
                path[d] = path[cur] + "D";
                q.add(d);
            }
            if (!visited[s]) {
                visited[s] = true;
                path[s] = path[cur] + "S";
                q.add(s);
            }
            if (!visited[l]) {
                visited[l] = true;
                path[l] = path[cur] + "L";
                q.add(l);
            }
            if (!visited[r]) {
                visited[r] = true;
                path[r] = path[cur] + "R";
                q.add(r);
            }
        }
        return ""; 
    }

    static int D(int n) {
        return (n * 2) % 10000;
    }

    static int S(int n) {
        return n == 0 ? 9999 : n - 1;
    }

    static int L(int n) {
        return (n % 1000) * 10 + (n / 1000);
    }

    static int R(int n) {
        return (n / 10) + (n % 10) * 1000;
    }
}
