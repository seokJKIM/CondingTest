class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i=1; i<=yellow/2+1; i++){
            if(yellow%i == 0){
                int r = i;
                int c = yellow/i;

                if((r*2+c*2+4) == brown){
                    answer[0] = c+2;
                    answer[1] = r+2;
                    break;
                }
            }
        }
        return answer;
    }
}