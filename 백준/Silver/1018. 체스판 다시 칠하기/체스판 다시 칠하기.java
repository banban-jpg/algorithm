import java.util.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); 

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j); //char 배열에 저장
            }
        }

        int result = 64;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repaint = countRepaint(i, j);
                if (repaint < result) {
                    result = repaint;
                }
            }
        }

        System.out.println(result);
    }

    static int countRepaint(int startX, int startY) {
        int countW = 0; // W로 시작
        int countB = 0; // B로 시작

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                char current = board[startX + x][startY + y]; // 해당 좌표 색상 추출

                if ((x + y) % 2 == 0) { // 짝수
                    if (current != 'W') countW++;
                    if (current != 'B') countB++;
                } else { // 홀수
                    if (current != 'B') countW++;
                    if (current != 'W') countB++;
                }
            }
        }
        return Math.min(countW, countB);
    }
}
