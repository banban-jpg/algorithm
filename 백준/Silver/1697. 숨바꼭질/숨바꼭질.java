import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        int[] visited = new int[MAX + 1];  // 0이면 미방문

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1; // 시작점 방문

        while (!q.isEmpty()) {
            int x = q.poll();

            // 동생 찾으면 시간-1
            if (x == K) {
                return visited[x] - 1;
            }

            // 이동 경우의 수 3가지 일 때
            int[] next = {x - 1, x + 1, x * 2};
            for (int nx : next) {
                if (nx >= 0 && nx <= MAX && visited[nx] == 0) {
                    visited[nx] = visited[x] + 1;
                    q.add(nx);
                }
            }
        }
        return -1;
    }
}
