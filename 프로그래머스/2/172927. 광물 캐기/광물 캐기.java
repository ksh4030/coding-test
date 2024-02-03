import java.util.*;
class Solution {
        static final int[][] score = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int cnt = Arrays.stream(picks).sum();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < minerals.length; i+=5) {
            if(cnt == 0) break;

            int da=0, ir=0, st=0;
            for (int j = i; j < i+5; j++) {
                int n = 0;
                try {
                    n = minerals[j].equals("iron") ? 1 : minerals[j].equals("stone") ? 2: 0;
                } catch (Exception e) {
                    break;
                }
                da += score[0][n];
                ir += score[1][n];
                st += score[2][n];
            }
            list.add(new Node(da, ir, st));
            cnt--;
        }

        list.sort((o1, o2) -> o2.stone - o1.stone);
        for(Node m : list) {
            int dia = m.diamond;
            int iron = m.iron;
            int stone = m.stone;

            if(picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
        }
        return answer;
    }
    
    
    public static class Node {
        int diamond, iron, stone;

        public Node(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
}