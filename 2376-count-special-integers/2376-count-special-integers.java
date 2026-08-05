class Solution {
    int[] digits;
    private int solve(int pos,boolean tight,int mask,boolean started){
        if(pos==digits.length){
            return started ? 1 : 0;
        }
        int limit=tight ? digits[pos] : 9;
        int ans=0;
        for(int digit=0;digit<=limit;digit++){
            boolean newTight= tight && (digit==limit);

            if(!started && digit==0){
                ans+=solve(pos+1,newTight,mask,false);
            }
            else{
                if((mask & (1<<digit))!=0) continue;
                int newMask= mask | (1<<digit);
                ans+=solve(pos+1,newTight,newMask,true);
            }
        }
        return ans;
    }
    public int countSpecialNumbers(int n) {
        String str=String.valueOf(n);
        digits=new int[str.length()];
        for(int i=0;i<str.length();i++){
            digits[i]=str.charAt(i)-'0';
        }
        return solve(0,true,0,false);
    }
}