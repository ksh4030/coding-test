class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int a = arrayA[0];
        int b = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
            b = gcd(b, arrayB[i]);
        }

        boolean checkA = true;
        boolean checkB = true;

        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i]%b == 0) {
                checkA = false;
                break;
            }
        }

        for (int i = 0; i < arrayB.length; i++) {
            if(arrayB[i]%a == 0) {
                checkB = false;
                break;
            }
        }

        if(checkA && checkB) {
            answer = Math.max(a, b);
        } else if (checkA){
            answer = b;
        } else if (checkB) {
            answer = a;
        }
        return answer;
    }
    public static int gcd(int a, int b) {
        if(b==0) return a;
        else return gcd(b, a%b);
    }
}