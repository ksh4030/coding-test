import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        left(s, 'R');
        left(s, 'B');
        right(s, 'R');
        right(s, 'B');

        System.out.println(cnt);
    }

    public static void left(String s, char target) {
        int idx = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == target) idx++;
            else break;
        }
        int c = 0;
        for(int i=idx; i<s.length(); i++) {
            if(s.charAt(i) == target) c++;
        }

        cnt = Math.min(cnt, c);
    }

    public static void right(String s, char target) {
        int idx = s.length() - 1;
        int c = 0;

        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == target) {
                idx--;
            } else {
                break;
            }
        }

        for(int i=idx; i>=0; i--) {
            if(s.charAt(i) == target) c++;
        }

        cnt = Math.min(cnt, c);
    }
}