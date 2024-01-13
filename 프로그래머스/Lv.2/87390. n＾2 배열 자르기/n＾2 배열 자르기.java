class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left);        
        int[] answer = new int[size+1];
        int idx = 0;
        
        for(long i=left; i<=right; i++) {
            long x = i / n;
            long y = i % n;
            answer[idx++] = Math.max((int)x, (int)y)+1;
        }
        
        return answer;
    }
}