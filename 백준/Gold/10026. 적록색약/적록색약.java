import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 일반인
        visited = new boolean[N][N];
        int normal = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    normal++;
                }
            }
        }

        // 적록색약용으로 R → G 변환
        convertRG();

        //  visited 초기화
        visited = new boolean[N][N];
        int colorWeak = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    colorWeak++;
                }
            }
        }

        System.out.println(normal + " " + colorWeak);
    }

    // DFS
    static void dfs(int x, int y, char color) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (!visited[nx][ny] && map[nx][ny] == color) {
                dfs(nx, ny, color);
            }
        }
    }

    //같은 색으로 바꿔주는 메서드
    static void convertRG() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }
    }
}
