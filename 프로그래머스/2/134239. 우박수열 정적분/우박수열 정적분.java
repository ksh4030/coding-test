import java.util.*;
class Solution {
    static List<Integer> list = new ArrayList<>();
    static double[] arr;
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        list.add(k);
        collatz(k);
        arr = new double[list.size()-1];
        getArea();
        // System.out.println(Arrays.toString(arr));
        // System.out.println(list);
        
        for(int i=0; i<ranges.length; i++) {
            int first = ranges[i][0];
            int last = arr.length + ranges[i][1];
            // System.out.println("===============");
            // System.out.println(first);
            // System.out.println(last);
            // System.out.println("===============");
            
            if(last<first) {
                answer[i] = -1;
            } else if (first == last) {
                answer[i] = 0;
            } else if (first == 0){
                answer[i] = arr[last-1];
            } else {
                answer[i] = arr[last-1] - arr[first-1];
            }
        }
        
        // System.out.println(list);
        // System.out.println(Arrays.toString(arr));
        return answer;
    }
    
    public void getArea() {
        arr[0] = (double)(list.get(0) + list.get(1))/2;
        for(int i=1; i<arr.length; i++) {
            arr[i] = arr[i-1] + (double)(list.get(i)+list.get(i+1)) / 2;
        }
    }
    
    public void collatz(int k){
        while(k > 1) {
            if(k%2 == 0) {
                k/=2;
            } else {
                k = k*3+1;
            }
            list.add(k);
        }
    }
}