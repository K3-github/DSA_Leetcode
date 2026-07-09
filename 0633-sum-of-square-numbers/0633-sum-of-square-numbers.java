class Solution {
    public boolean judgeSquareSum(int c) {
        long low=0,high=(long)Math.sqrt(c)+1;
        while(low<=high){
            long res=low*low+high*high;
            if(res==c) return true;
            else if(res>c) high=high-1;
            else low=low+1;
        }
        return false;
    }
}