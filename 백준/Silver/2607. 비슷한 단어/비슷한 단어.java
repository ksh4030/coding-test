import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String begin = br.readLine();
        int cnt = 0;

        for (int i = 1; i < N; i++) {
            String s = br.readLine();
            if(isPossible(begin, s)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isPossible(String begin, String s) {
        if(Math.abs(begin.length() - s.length()) > 1) return false;

        int[] cnt = new int[26];
        for(int i=0; i<begin.length(); i++) cnt[begin.charAt(i) - 'A']++;
        for(int i=0; i<s.length(); i++) cnt[s.charAt(i) - 'A']--;

        int beginCnt = 0;
        int sCnt = 0;
        for(int n : cnt) {
            if(n > 0) beginCnt += n;
            else sCnt += n * -1;
        }

        return (beginCnt == 0 && sCnt == 0) || (beginCnt == 1 && sCnt == 0) || (beginCnt == 0 && sCnt == 1) || (beginCnt == 1 && sCnt == 1);
    }
}
