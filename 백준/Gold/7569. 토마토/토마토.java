import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 (x)
        N = Integer.parseInt(st.nextToken()); // 세로 (y)
        H = Integer.parseInt(st.nextToken()); // 높이 (z)

        box = new int[H][N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    box[z][y][x] = Integer.parseInt(st.nextToken());
                    if (box[z][y][x] == 1) q.add(new int[]{z, y, x});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cz = cur[0], cy = cur[1], cx = cur[2];
            for (int k = 0; k < 6; k++) {
                int nz = cz + dz[k];
                int ny = cy + dy[k];
                int nx = cx + dx[k];
                if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (box[nz][ny][nx] != 0) continue;
                box[nz][ny][nx] = box[cz][cy][cx] + 1;
                q.add(new int[]{nz, ny, nx});
            }
        }

        int max = 0;
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (box[z][y][x] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (box[z][y][x] > max) max = box[z][y][x];
                }
            }
        }

        System.out.println(max == 1 ? 0 : max - 1);
    }
}
