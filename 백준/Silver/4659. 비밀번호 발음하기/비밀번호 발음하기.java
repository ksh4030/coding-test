import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if(s.equals("end")) break;

            if(isPossible(s)) {
                System.out.println("<" + s + ">" + " is acceptable.");
            } else {
                System.out.println("<" + s + ">" + " is not acceptable.");
            }
        }
    }

    public static boolean isPossible(String s) {
        int v=0, c=0;
        boolean isV = false;

        for(int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);

            if("aeiou".indexOf(tmp) != -1) {
                isV = true;
                v++;
                c = 0;
            } else {
                c++;
                v = 0;
            }

            if(i > 0 && ("eo".indexOf(tmp) == -1) && s.charAt(i - 1) == tmp) return false;
            if(v == 3 || c == 3) return false;
        }

        return isV;
    }
}