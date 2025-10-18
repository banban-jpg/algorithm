import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int count = 1; 

        while (B > A) {
            if (B % 10 == 1) {
                B /= 10; // 끝자리가 1이면 10으로 나누기
            } else if (B % 2 == 0) {
                B /= 2; // 짝수면 나누기2
            } else {
                break; 
            }
            count++;
        }

        System.out.println(B == A ? count : -1);
    }
}
