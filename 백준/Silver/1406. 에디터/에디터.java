import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N;
    static Stack<String> mainBucket = new Stack<>();
    static Stack<String> subBucket = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        typing(br);

        StringBuilder sb = new StringBuilder();
        while (!mainBucket.isEmpty()) {
            sb.append(mainBucket.pop());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
    }

    public static void typing(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("P")) {
                String a = st.nextToken();
                mainBucket.push(a);
            } else if (s.equals("L")) {
                if(mainBucket.size() > 0) {
                    subBucket.push(mainBucket.pop());
                }
            } else if (s.equals("D")) {
                if(subBucket.size() > 0) {
                    mainBucket.push(subBucket.pop());
                }
            } else {
                if(mainBucket.size() > 0) {
                    mainBucket.pop();
                }
            }
        }

        while (!subBucket.isEmpty()) {
            mainBucket.push(subBucket.pop());
        }
    }

    public static void init(BufferedReader br) throws IOException {
        String[] word = br.readLine().split("");
        N = Integer.parseInt(br.readLine());

        for(String s : word) mainBucket.push(s);
    }
}
