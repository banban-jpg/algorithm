import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int maxSafe = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);
        System.out.println(maxSafe);
    }

    // DFS
    static void buildWall(int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // BFS
    static void spreadVirus() {
        int[][] temp = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        // 맵 복사, 바이러스 위치 큐에 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
                if (temp[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        countSafe(temp);
    }

    // 안전 영역 계산
    static void countSafe(int[][] temp) {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) safe++;
            }
        }
        maxSafe = Math.max(maxSafe, safe);
    }
}
