import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] field;
    static boolean[][] visited;

    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken()); 
            K = Integer.parseInt(st.nextToken()); 

            field = new int[N][M];
            visited = new boolean[N][M];

            // 배추 위치
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1; 
            }

            int wormCount = 0;

            // 좌표 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j); // 새로운 덩어리 탐색
                        wormCount++;
                    }
                }
            }

            sb.append(wormCount).append("\n");
        }

        System.out.print(sb.toString());
    }

    // DFS
    static void dfs(int y, int x) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{y, x});
        visited[y][x] = true;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cy = cur[0];
            int cx = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (field[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        stack.push(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
