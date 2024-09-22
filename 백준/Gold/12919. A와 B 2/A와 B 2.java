import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String s;
    static String t;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        s = br.readLine();
        t = br.readLine();

        isPossible(t);
        System.out.println(answer);
    }


    public static void isPossible(String current) {
        if (current.equals(s)) {
            answer = 1;
            return;
        }
        if (current.length() <= s.length()) {
            return;
        }

        if (current.charAt(current.length() - 1) == 'A') {
            isPossible(current.substring(0, current.length() - 1));
        }

        if (current.charAt(0) == 'B') {
            isPossible(new StringBuilder(current.substring(1)).reverse().toString());
        }
    }
}