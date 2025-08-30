import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); 
        int count = 0; // 봉지 개수

        while (true) {
            if (N % 5 == 0) {       // 5kg 봉지 나누기
                count += N / 5;
                bw.write(count + "\n");
                break;
            }
            N -= 3;                  // 3kg 봉지 사용
            count++;         

            if (N < 0) {             // 실패 시
                bw.write("-1\n");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
