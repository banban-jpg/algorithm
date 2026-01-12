import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map, tmp;
    static int airTop, airBottom;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        airTop = airBottom = -1;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (airTop == -1) airTop = i;
                    else airBottom = i;
                }
            }
        }

        while (T-- > 0) {
            spread();
            cleanTop();
            cleanBottom();
        }

        System.out.println(totalDust());
    }

    static void spread() {
        tmp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int amount = map[i][j] / 5;
                    int cnt = 0;

                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];
                        if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
                        if (map[ni][nj] == -1) continue;
                        tmp[ni][nj] += amount;
                        cnt++;
                    }
                    map[i][j] -= amount * cnt;
                }
            }
        }

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                map[i][j] += tmp[i][j];
    }

    static void cleanTop() {
        int r = airTop;
        for (int i = r - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int j = 0; j < C - 1; j++) map[0][j] = map[0][j + 1];
        for (int i = 0; i < r; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int j = C - 1; j > 1; j--) map[r][j] = map[r][j - 1];
        map[r][1] = 0;
    }

    static void cleanBottom() {
        int r = airBottom;
        for (int i = r + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int j = 0; j < C - 1; j++) map[R - 1][j] = map[R - 1][j + 1];
        for (int i = R - 1; i > r; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int j = C - 1; j > 1; j--) map[r][j] = map[r][j - 1];
        map[r][1] = 0;
    }

    static int totalDust() {
        int sum = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (map[i][j] > 0) sum += map[i][j];
        return sum;
    }
}
