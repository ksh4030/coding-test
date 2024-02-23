import java.util.*;
import java.io.*;

class Solution {
    static int row, column, answer;
    static ArrayList<ArrayList<Integer>> candidate = new ArrayList<ArrayList<Integer>>();
    static boolean sel[];

    public int solution(String[][] relation) {
        answer = 0;

        row = relation.length;
        column = relation[0].length;
        sel = new boolean[column];

        DFS(0, relation);

        return answer;
    }

    public static void DFS(int idx, String[][] relation) {
        if (idx == column) {
            // 유일성 확인
            if (!uniqueness(relation)) return;
            // 최소성 확인
            if (!minimality()) return;

            candidate.add(new ArrayList<Integer>());
            for (int i = 0; i < column; i++) {
                if (sel[i]) {
                    candidate.get(candidate.size() - 1).add(i);
                }
            }

            answer++;
            return;
        }
        sel[idx] = false;
        DFS(idx + 1, relation);
        sel[idx] = true;
        DFS(idx + 1, relation);
    }

    // 유일성 확인
    public static boolean uniqueness(String[][] relation) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < column; j++) {
                if (sel[j]) {
                    sb.append(relation[i][j]).append(" ");
                }
            }
            String key = sb.toString();
            if (!set.add(key)) {
                return false;
            }
        }
        return true;
    }

    // 최소성 확인
    public static boolean minimality() {
        // 1개는 반드시 최소성을 만족한다!
        if (candidate.size() == 0) return true;

        for (ArrayList<Integer> tmp : candidate) {
            int pos = 0;
            for (int i = 0; i < tmp.size(); i++) {
                if (sel[tmp.get(i)]) pos++;
            }
            // 최소성을 만족하지 못한다 !
            if (pos == tmp.size()) return false;
        }
        // 최소성을 만족한다 !
        return true;
    }
}
