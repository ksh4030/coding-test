class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];

        int[][] arr = new int[n][n];

        int cnt = 1;
        int r =-1, c=0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i%3 == 0) r++;
                else if (i%3 == 1) c++;
                else if (i%3 == 2) {
                    r--;
                    c--;
                }
                arr[r][c] = cnt++;
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 0) continue;
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}