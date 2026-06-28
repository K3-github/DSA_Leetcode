class Solution {
    public int maxDistance(String moves) {
        int x1=0,x2=0,y1=0;
        for(char ch: moves.toCharArray()){
            if(ch=='L'){
                x1-=1;x2-=1;
            }
            else if(ch=='R'){
                x1+=1;x2+=1;
            }
            else if(ch=='D'){
                y1-=1;
            }
            else if(ch=='U'){
                y1+=1;
            }
            else{
                x1-=1;x2+=1;
            }
        }
        return Math.max(Math.abs(x1)+Math.abs(y1),Math.abs(x2)+Math.abs(y1));
    }
}