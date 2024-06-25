class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i++){
            int number = Integer.parseInt(arr[i]);
            if(number > max) max = number;
            if(number < min) min = number;
        }
        
        return min+" "+max;
    }
}