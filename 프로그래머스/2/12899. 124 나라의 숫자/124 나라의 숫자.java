class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"4", "1", "2"};

        while (n > 0) {
            int nmj = n % 3;
            n /= 3;

            if(nmj == 0) n--;

            answer = arr[nmj] + answer;
        }
        return answer;
    }
}