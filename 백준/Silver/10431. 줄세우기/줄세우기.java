import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            String bucket = st.nextToken();
            int res = 0;

            List<Integer> list = new ArrayList<>();

            for(int j=0; j<20; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(list.size() == 0) {
                    list.add(num);
                    continue;
                }

                int idx = -1;

                for(int k=0; k<list.size(); k++) {
                     if(list.get(k) > num) {
                         idx = k;
                         break;
                     }
                }

                if(idx == -1) {
                    list.add(num);
                } else {
                    res+= list.size() - idx;
                    list.add(idx, num);
                }
            }
            System.out.println(bucket + " " + res);
        }

    }
}