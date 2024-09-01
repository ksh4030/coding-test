import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if (n < 3) return n;
        
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        leftMin[0] = a[0];
        rightMin[n-1] = a[n-1];
        
        // 왼쪽에서 오른쪽으로 최소값 저장
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i-1], a[i]);
        }
        
        // 오른쪽에서 왼쪽으로 최소값 저장
        for (int i = n-2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], a[i]);
        }
        
        int answer = 2; // 양 끝의 풍선은 남을 수 있음
        
        // 중간의 풍선이 남을 수 있는지 확인
        for (int i = 1; i < n-1; i++) {
            if (a[i] <= leftMin[i-1] || a[i] <= rightMin[i+1]) {
                answer++;
            }
        }
        
        return answer;
    }
}