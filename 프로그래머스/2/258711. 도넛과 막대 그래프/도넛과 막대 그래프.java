import java.util.Arrays;

class Solution {
    public int[] solution(int[][] edges) {
        int M = edges.length;
        // 1) 노드 최대 번호 찾기
        int maxNode = 0;
        for (int i = 0; i < M; i++) {
            int u = edges[i][0], v = edges[i][1];
            if (u > maxNode) maxNode = u;
            if (v > maxNode) maxNode = v;
        }
        int N = maxNode + 1;

        // 2) 진입차수·진출차수 계산, forward‐star 인접리스트 구축
        int[] indegree  = new int[N];
        int[] outdegree = new int[N];
        int[] head = new int[N];
        Arrays.fill(head, -1);
        int[] to   = new int[M];
        int[] nxt  = new int[M];
        for (int i = 0; i < M; i++) {
            int u = edges[i][0], v = edges[i][1];
            indegree[v]++;
            outdegree[u]++;
            to[i]   = v;
            nxt[i]  = head[u];
            head[u] = i;
        }

        // 3) 생성된 정점 t 찾기: indegree==0 이면서 outdegree>=2
        int t = -1;
        for (int i = 1; i < N; i++) {
            if (indegree[i] == 0 && outdegree[i] >= 2) {
                t = i;
                break;
            }
        }

        // 4) t 에서 나가는 간선들로 각 컴포넌트 루트 v 확보 → BFS/DFS 로 내부 노드·간선 수 집계
        boolean[] visited = new boolean[N];
        int[] queue = new int[N];
        int donut = 0, bar = 0, eight = 0;

        for (int e = head[t]; e != -1; e = nxt[e]) {
            int v = to[e];
            if (visited[v]) continue;

            // BFS 시작
            int qh = 0, qt = 0;
            visited[v] = true;
            queue[qt++] = v;
            int nodeCnt = 0, edgeCnt = 0;

            while (qh < qt) {
                int u = queue[qh++];
                nodeCnt++;
                for (int k = head[u]; k != -1; k = nxt[k]) {
                    int w = to[k];
                    edgeCnt++;
                    if (!visited[w] && w != t) {
                        visited[w] = true;
                        queue[qt++] = w;
                    }
                }
            }

            // classification by (edgeCnt - nodeCnt):
            //   0 → donut (cycle)
            //  -1 → bar   (path)
            //  +1 → eight (two cycles share a vertex)
            if      (edgeCnt == nodeCnt)       donut++;
            else if (edgeCnt == nodeCnt - 1)   bar++;
            else if (edgeCnt == nodeCnt + 1)   eight++;
            // (문제 조건상 그 외 경우는 없음)
        }

        return new int[]{ t, donut, bar, eight };
    }
}
