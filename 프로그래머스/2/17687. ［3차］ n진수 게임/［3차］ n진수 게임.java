class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String bucket = "";

        int cnt = 0;
        while (bucket.length()/m <= t) {
            bucket += Integer.toString(cnt++, n);
        }
        for (int i = p-1; i < bucket.length(); i+=m) {
            answer += String.valueOf(bucket.charAt(i));
            if(answer.length() == t) {
                break;
            }
        }
        return answer.toUpperCase();
    }
}