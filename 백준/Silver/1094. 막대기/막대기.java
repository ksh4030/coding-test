import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        String s = Integer.toBinaryString(n);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') ans++;
        }
        System.out.println(ans);
    }
}
