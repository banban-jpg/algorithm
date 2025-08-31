import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        FindTrue findtrue = new FindTrue();

        int T = Integer.parseInt(br.readLine()); 
        for (int i = 0; i < T; i++) {
    String stack = br.readLine();
    bw.write(findtrue.answer(stack) + "\n");
}


        bw.flush();
        bw.close();
        br.close();
    }
}

class FindTrue {
    public String answer(String input) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (!st.isEmpty() && st.peek() == '(' && input.charAt(i) == ')') {
                st.pop();
            } else {
                st.push(input.charAt(i));
            }
        }

        return st.isEmpty() ? "YES" : "NO";
    }
}
