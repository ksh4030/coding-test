class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        Bucket bucket = new Bucket("", 0);

        m = change(m);
        for (String s : musicinfos) {
            String[] arr = s.split(",");
            arr[3] = change(arr[3]);
            Node node = check(arr, m);
            if(node.flag) {
                if (bucket.time < node.time) {
                    bucket = new Bucket(arr[2], node.time);
                }
            }
        }

        answer = bucket.name;
        if (answer.length() <= 0) answer = "(None)";
        return answer;
    }
    
    public static Node check(String[] arr, String hear) {
        int t = Integer.parseInt(arr[1].split(":")[0]) - Integer.parseInt(arr[0].split(":")[0]);
        int m = Integer.parseInt(arr[1].split(":")[1]) - Integer.parseInt(arr[0].split(":")[1]);
        int time = (t*60) + m;
        String target = "";

        int idx = 0;
        for (int i = 0; i < time; i++) {
            if (idx >= arr[3].length()) idx = 0;
            target += arr[3].charAt(idx);
            idx++;
        }
        System.out.println(target);
        if (target.contains(hear)) return new Node(true, time);

        return new Node(false, time);
    }

    public static String change(String s) {
        s = s.replaceAll("C#", "H");
        s = s.replaceAll("D#", "I");
        s = s.replaceAll("F#", "J");
        s = s.replaceAll("G#", "K");
        s = s.replaceAll("A#", "L");


        return s;
    }

    static class Node {
        boolean flag;
        int time;
        public Node(boolean flag, int time) {
            this.flag = flag;
            this.time = time;
        }
    }
    
    static class Bucket {
        String name;
        int time;
        public Bucket(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }
}