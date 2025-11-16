import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            solveTestCase();
        }
        System.out.print(sb);
    }

    // 테스트 케이스
    private static void solveTestCase() throws IOException {
        int k = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();

        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if (cmd == 'I') {
                insert(num, minQ, maxQ, countMap);
            } else {
                delete(num, minQ, maxQ, countMap);
            }
        }

        clean(minQ, countMap);
        clean(maxQ, countMap);

        if (countMap.isEmpty()) {
            sb.append("EMPTY\n");
            return;
        }

        int max = maxQ.peek();
        int min = minQ.peek();
        sb.append(max).append(" ").append(min).append("\n");
    }

    // 삽입 메서드
    private static void insert(int num, PriorityQueue<Integer> minQ,
                               PriorityQueue<Integer> maxQ, Map<Integer, Integer> map) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        minQ.add(num);
        maxQ.add(num);
    }

    // 삭제 메서드 
    private static void delete(int type, PriorityQueue<Integer> minQ,
                               PriorityQueue<Integer> maxQ, Map<Integer, Integer> map) {

        if (map.isEmpty()) return;  // 

        if (type == 1) { // 최대 삭제
            clean(maxQ, map);
            int max = maxQ.poll();
            decreaseCount(max, map);
        } else { // 최소 삭제
            clean(minQ, map);
            int min = minQ.poll();
            decreaseCount(min, map);
        }
    }

    // 실제 존재하지 않는 값들 제거
    private static void clean(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        while (!pq.isEmpty() && !map.containsKey(pq.peek())) {
            pq.poll();
        }
    }

    // countMap 감소 및 삭제
    private static void decreaseCount(int num, Map<Integer, Integer> map) {
        int c = map.get(num);
        if (c == 1) map.remove(num);
        else map.put(num, c - 1);
    }
}
