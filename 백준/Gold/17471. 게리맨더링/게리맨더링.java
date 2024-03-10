import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, answer;
    static int[] population, standard;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        population = new int[N];
        list = new List[N];
        standard = new int[N];
        for(int i=0; i<N; i++) {
            standard[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            for (int j = 0; j < len; j++) {
                int target = Integer.parseInt(st.nextToken())-1;
                list[i].add(target);
            }
        }

        for(int i=1; i<=N/2; i++) {
            comb(0, 0, new int[i]);
        }

        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
    static void getPopulation(int[] a, int[] b) {
        int sumA=0, sumB=0;
        for(int i=0; i<a.length; i++) {
            sumA += population[a[i]];
        }
        for(int i=0; i<b.length; i++) {
            sumB += population[b[i]];
        }

        answer = Math.min(answer, Math.abs(sumA - sumB));
    }

    static boolean check(int[] arr) {
        boolean[] check = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);
        check[arr[0]] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            int len = list[current].size();
            for(int i=0; i<len; i++) {
                for(int j=0; j<arr.length; j++) {
                    if(!check[list[current].get(i)] && list[current].get(i) == arr[j]) {
                        q.add(list[current].get(i));
                        check[list[current].get(i)] = true;
                        cnt++;
                    }
                }
            }
        }

        if(cnt == arr.length) {
            return true;
        } else {
            return false;
        }
    }

    static void comb(int idx, int k, int[] sel) {
        if(k == sel.length) {
            int[] other = new int[N - sel.length];
            int index = 0;
            for(int i=0; i<N; i++) {
                boolean flag = false;
                for(int j=0; j<sel.length; j++) {
                    if(sel[j] == i) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    other[index++] = i;
                }
            }
            if(check(sel) && check(other)) {
                getPopulation(sel, other);
            }
            return;
        }

        for (int i = idx; i < standard.length; i++) {
            sel[k] = standard[i];
            comb(i+1, k+1, sel);
        }
    }
}

