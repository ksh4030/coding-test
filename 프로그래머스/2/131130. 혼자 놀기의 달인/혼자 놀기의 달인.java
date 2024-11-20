import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visit = new boolean[cards.length];
        List<Integer> groupSizes = new ArrayList<>();

        // 각 그룹의 크기를 계산
        for (int i = 0; i < cards.length; i++) {
            if (!visit[i]) {
                groupSizes.add(dfs(cards, i, visit));
            }
        }

        // 그룹 크기 내림차순 정렬
        Collections.sort(groupSizes, Collections.reverseOrder());

        // 상위 두 그룹 크기의 곱 계산
        if (groupSizes.size() < 2) {
            return 0; // 그룹이 하나라면 점수는 0
        } else {
            return groupSizes.get(0) * groupSizes.get(1);
        }
    }

    private int dfs(int[] cards, int idx, boolean[] visit) {
        int count = 0;

        while (!visit[idx]) {
            visit[idx] = true;
            idx = cards[idx] - 1; // 다음 상자 이동
            count++;
        }

        return count;
    }
}
