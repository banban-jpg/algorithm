import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] air;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

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

        int time = 0;

        while (true) {
            markOutsideAir();
            List<int[]> meltList = findCheeseToMelt();

            if (meltList.isEmpty()) break;

            for (int[] p : meltList) {
                map[p[0]][p[1]] = 0;
            }

            time++;
        }

        System.out.println(time);
    }

    // BFS
    static void markOutsideAir() {
        air = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        air[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (air[nr][nc] || map[nr][nc] == 1) continue;

                air[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }

    // 녹는치즈 찾기
    static List<int[]> findCheeseToMelt() {
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (map[i][j] == 1) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];
                        if (air[ni][nj]) cnt++;
                    }
                    if (cnt >= 2) {
                        list.add(new int[]{i, j});
                    }
                }
            }
        }
        return list;
    }
}
