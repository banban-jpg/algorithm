import java.io.*;
import java.util.*;

public class Main {

    // 이진탐색
    public static List<Integer> finalAnswer(int[] li1, int[] li2) {
        List<Integer> li3 = new ArrayList<>();
        Arrays.sort(li1); // li1 정렬
        
        for (int target : li2) {
            int left = 0, right = li1.length - 1;
            boolean found = false;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (li1[mid] == target) {
                    li3.add(1); //성공 시
                    found = true;
                    break;
                } else if (li1[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (!found) li3.add(0); //실패 시
        }

        return li3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int F = Integer.parseInt(br.readLine());
        int[] li1 = new int[F];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < F; i++) {
            li1[i] = Integer.parseInt(st.nextToken());
        }


        int R = Integer.parseInt(br.readLine());
        int[] li2 = new int[R];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            li2[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = finalAnswer(li1, li2);

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int item : result) {
            bw.write(item + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
