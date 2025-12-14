import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int sharkX, sharkY;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        simulate();
        System.out.println(time);
    }

    static void simulate() {
        while (true) {
            Fish target = bfs();
            if (target == null) return;

            time += target.dist;
            sharkX = target.x;
            sharkY = target.y;

            map[sharkX][sharkY] = 0;
            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }
    }

    static Fish bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;

        List<Fish> fishes = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (dist > minDist) break;

            if (map[x][y] > 0 && map[x][y] < sharkSize) {
                fishes.add(new Fish(x, y, dist));
                minDist = dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }

        if (fishes.isEmpty()) return null;

        fishes.sort((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        return fishes.get(0);
    }

    static class Fish {
        int x, y, dist;

        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
