class Solution {
    int[] digits;
    int len;
    private int solve(int pos,boolean tight,int mask){
        if(pos==len) return mask==0 ? 0 : 1;

        int limit=tight ? digits[pos] : 9;
        int ans=0;

        for(int digit=0;digit<=limit;digit++){
            boolean newTight=tight && (digit==limit);
            if(mask==0 && digit==0){
                ans+=solve(pos+1,newTight,mask);
            }
            else{
                if((mask & (1<<digit))!=0) continue;

                int newMask=mask | (1<<digit);
                ans+=solve(pos+1,newTight,newMask);
            }
        }
        return ans;
    }
    public int numDupDigitsAtMostN(int n) {
        String str=String.valueOf(n);
        len=str.length();
        digits=new int[len];
        for(int i=0;i<len;i++){
            digits[i]=str.charAt(i)-'0';
        }
        return n-solve(0,true,0);
    }
}