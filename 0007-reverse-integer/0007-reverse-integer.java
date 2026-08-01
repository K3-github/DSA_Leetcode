class Solution {
    public int reverse(int x) {
        int y=x;
        y=Math.abs(y);
        long rev=0;
        while(y>0){
            rev=rev*10+(y%10);
            y/=10;
        }
        if(rev>Integer.MAX_VALUE) return 0;
        if(x<0) return -(int)rev;
        return (int)rev;
    }
}