import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        List<Integer> truthPeople = new ArrayList<>();
        for (int i = 0; i < truthCount; i++) {
            truthPeople.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            // 같은 파티 사람 묶기
            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }
        }

        // 진실을 아는 그룹 찾기
        Set<Integer> truthRoots = new HashSet<>();
        for (int person : truthPeople) {
            truthRoots.add(find(person));
        }

        // 거짓말 가능한 파티 카운트
        int liePossible = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthRoots.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) liePossible++;
        }

        System.out.println(liePossible);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }
}
