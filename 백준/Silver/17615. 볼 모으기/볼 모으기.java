import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int a = cal(N, s, 'R');
        int b = cal(N, s, 'B');

        System.out.println(Math.min(a, b));
    }

    public static int cal(int N, String s, char target) {
        int isTarget = 0;
        int unTarget = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == target) {
                isTarget++;
            } else {
                unTarget++;
            }
        }

        int left = isTarget + unTarget;
        int right = 0;

        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == target) {
                left--;
                right++;
            } else {
                break;
            }
        }

        int cnt = 0;
        int idx = 0;

        while (true) {
            if(isTarget == right && unTarget == left) return cnt;

            if(s.charAt(idx) == target) {
                left--;
                right++;
                cnt++;
            }
            idx++;
        }
    }
}