import java.io.*;

import java.util.*;

public class Main {

    static int M, N;

    static int[][] box;

    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {1, -1, 0, 0};

    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로

        N = Integer.parseInt(st.nextToken()); // 세로

        box = new int[N][M];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {

                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {

                    queue.offer(new int[]{i, j});

                }

            }

        }

        bfs();

        System.out.println(getResult());

    }

    //  BFS

    static void bfs() {

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            int x = cur[0];

            int y = cur[1];

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];

                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (box[nx][ny] != 0) continue;

                box[nx][ny] = box[x][y] + 1;

                queue.offer(new int[]{nx, ny});

            }

        }

    }

    // 결과 계산

    static int getResult() {

        int maxDay = 0;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {

                if (box[i][j] == 0) {

                    return -1;

                }

                maxDay = Math.max(maxDay, box[i][j]);

            }

        }

        return maxDay - 1;

    }

}

