class Solution {
    static int reg = 0;
    static int earnSum = 0;
    static int[] percent = {10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        int[] arr = new int[emoticons.length];
        comb(arr, 0, users, emoticons);

        answer[0] = reg;
        answer[1] = earnSum;
        return answer;
    }
    
    static void comb (int[] arr, int idx, int[][] users, int[] emoticons) {
        if(idx == arr.length) {
            cal(arr, users, emoticons);
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr[idx] = percent[i];
            comb(arr, idx+1, users, emoticons);
        }
    }
    
        static void cal(int[] arr, int[][] users, int[] emoticons) {
        int cnt = 0;
        int earn = 0;

        for(int[] user : users) {
            int discount = user[0];
            int limit = user[1];
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] >= discount) {
                    sum += (emoticons[i]/100) * (100-arr[i]);
                }
            }

            if(sum >= limit) cnt++;
            else earn += sum;
        }

        if (cnt > reg) {
            reg = cnt;
            earnSum = earn;
        } else if (cnt == reg) {
            if(earn > earnSum) {
                earnSum = earn;
            }
        }
    }
}