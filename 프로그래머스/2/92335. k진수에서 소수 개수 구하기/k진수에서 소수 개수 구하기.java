class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        String[] arr = s.split("");

        for (int i = 0; i < arr.length; i++) {
            String target = "";
            for (int j = i; j < arr.length; j++) {
                if(arr[j].equals("0")) {
                    break;
                }
                target+=arr[j];
            }
            if(prime(target)) {
                answer++;
            }
            i+=target.length();
        }

        System.out.println(answer);
        return answer;
    }
        public static boolean prime(String target) {
        if(target.equals("")) {
            return false;
        }
        long l = Long.parseLong(target);
        if(l <= 1) {
            return false;
        }
        if (l == 2) {
            return true;
        }

        for (int i = 3; i <= Math.sqrt(l); i++) {
            if(l%i==0) {
                return false;
            }
        }
        return true;
    }
}