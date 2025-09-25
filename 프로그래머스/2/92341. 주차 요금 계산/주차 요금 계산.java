import java.util.*;
class Solution {
    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> info = new HashMap<>();
    static Set<Integer> set = new HashSet<>();

    static int basic_min, basic_pay, extra_min, extra_pay;
    static int idx = 0;

    public int[] solution(int[] fees, String[] records) {

        basic_min = fees[0];
        basic_pay = fees[1];
        extra_min = fees[2];
        extra_pay = fees[3];

        for (String s : records) parking(s.split(" "));

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] answer = new int[list.size()];

        for (int num : list) {
            pay(num, answer);
        }
        return answer;
    }

    public void pay(int num, int[] answer) {
        int time = map.getOrDefault(num, 0);
        if (info.containsKey(num)) {
            time += 23 * 60 + 59 - info.get(num);
        }
        answer[idx++] = cal(time);
    }

    public int cal(int time) {
        if (time <= basic_min) return basic_pay;
        int extra = time - basic_min;
        int units = (extra + extra_min - 1) / extra_min;
        return basic_pay + units * extra_pay;
    }

    public void parking(String[] arr) {
        int time = StringToInt(arr[0]);
        int num = Integer.parseInt(arr[1]);
        String io = arr[2];

        if (io.equals("IN")) {
            info.put(num, time);
            set.add(num);
        } else {
            time -= info.get(num);
            info.remove(num);
            map.put(num, map.getOrDefault(num, 0) + time);
            set.add(num);
        }
    }

    public int StringToInt(String s) {
        String[] arr = s.split(":");
        int h = Integer.parseInt(arr[0]) * 60;
        int m = Integer.parseInt(arr[1]);
        return h + m;
    }
}