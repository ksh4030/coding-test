import java.util.*;

class Solution {
    int[] parent; // 유니온-파인드 배열

    // find 연산 (경로 압축)
    private int find(int v) {
        if (parent[v] != v) parent[v] = find(parent[v]); // 부모 갱신
        return parent[v];
    }

    // union 연산 (사이클 방지)
    private boolean union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 == root2) return false; // 같은 집합이면 합치지 않음
        parent[root2] = root1; // 하나의 집합으로 연결
        return true;
    }

    public int solution(int n, int[][] costs) {
        // 1. 간선 정렬 (비용 기준)
        Arrays.sort(costs, Comparator.comparingInt(e -> e[2]));

        // 2. 유니온-파인드 배열 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // 3. 크루스칼 알고리즘 실행
        int mstCost = 0, edgeCount = 0;
        for (int[] cost : costs) {
            if (union(cost[0], cost[1])) { // 사이클 방지
                mstCost += cost[2];
                edgeCount++;
                if (edgeCount == n - 1) break; // MST 완성
            }
        }

        return mstCost;
    }
}
