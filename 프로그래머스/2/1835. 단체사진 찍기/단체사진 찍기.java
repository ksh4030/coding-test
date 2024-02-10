class Solution {
    static String[] man = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static String[] bucket;
    static boolean[] v;
    static int target;
    public int solution(int n, String[] data) {
        int answer = 0;
        target = 0;
        v = new boolean[man.length];
        bucket = data.clone();
        per(0, "");
        return target;
    }
    
    public static void per(int idx, String sel) {
        if(idx == man.length) {
            if(check(sel)) target++;
            return;
        }

        for (int i = 0; i < man.length; i++) {
            if(!v[i]) {
                v[i]=true;
                per(idx+1, sel+man[i]);
                v[i]=false;
            }
        }
    }

    public static boolean check(String sel) {
        for (String s : bucket) {

            int a = sel.indexOf(s.charAt(0));
            int b = sel.indexOf(s.charAt(2));

            switch (s.charAt(3)) {
                case '=':
                    if (Math.abs(a - b) - 1 != s.charAt(4)-'0') return false;
                    break;
                case '>':
                    if (Math.abs(a - b) - 1 <= s.charAt(4)-'0') return false;
                    break;
                case '<':
                    if (Math.abs(a - b) - 1 >= s.charAt(4)-'0') return false;
                    break;
            }
        }
        return true;
    }
}