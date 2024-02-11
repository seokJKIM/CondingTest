class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1; i<=yellow/2+1; i++){
            if(yellow%i == 0){
                int row = i;
                int col = yellow/row;
            
                if(row*2+(col+2)*2 == brown){
                    answer[0] = col+2;
                    answer[1] = row+2;
                    break;
                }
            }
            
        }
        
        return answer;
    }
}