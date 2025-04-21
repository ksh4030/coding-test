import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int idx = 0;
        int targetLen = s.length();

        for (int i = 1; ; i++) {
            char[] digits = Integer.toString(i).toCharArray();
            for (char c : digits) {
                if (c == s.charAt(idx)) {
                    idx++;
                    if (idx == targetLen) {
                        System.out.println(i);
                        return;
                    }
                }
            }
        }
    }
}
