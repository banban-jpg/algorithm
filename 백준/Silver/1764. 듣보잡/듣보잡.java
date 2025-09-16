import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 처리하기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N과 M 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 듣도 못한 사람을 저장할 HashSet
        HashSet<String> unheard = new HashSet<>();
        
        // 듣도 못한 사람 입력
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }
        
        // 교집합 결과를 저장할 List
        List<String> result = new ArrayList<>();
        
        // 보도 못한 사람과 교집합 확인
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                result.add(name);
            }
        }
        
        // 결과를 사전순으로 정렬
        Collections.sort(result);
        
        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
