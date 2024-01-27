class Solution {
    static String[] arr;
    public int solution(int storey) {
        int answer = 0;
        arr = Integer.toString(storey).split("");

        String cur = arr[arr.length-1];

        for (int i = arr.length-2; i >= 0; i--) {
            if(Integer.parseInt(cur) > 5) {
                answer += 10 - Integer.parseInt(cur);
                arr[i] = Integer.toString(Integer.parseInt(arr[i]) + 1);
            } else if (Integer.parseInt(cur) < 5) {
                answer += Integer.parseInt(cur);
            } else {
                answer+=5;
                if(Integer.parseInt(arr[i]) >= 5) {
                    arr[i] = Integer.toString(Integer.parseInt(arr[i]) + 1);
                }
            }

            if(arr[i].length() >= 2) {
                cal(i);
            }
            cur = arr[i];
        }

        if(arr[0].length() >= 2) {
            answer++;
            cur = String.valueOf(arr[0].charAt(1));
        } else {
            cur = arr[0];
        }

        if(Integer.parseInt(cur) > 5) {
            answer += 10 - Integer.parseInt(cur) + 1;
        } else {
            answer += Integer.parseInt(cur);
        }
        return answer;
    }
    public static void cal(int i) {
        for(int j=i; j>=1; j--) {
            if(arr[j].length() == 1) {
                break;
            }

            arr[j] = Integer.toString(Integer.parseInt(arr[j]) - 10);
            arr[j-1] = Integer.toString(Integer.parseInt(arr[j-1]) + 1);
        }
    }
}