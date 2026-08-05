class Solution {
    private int solve(int pos,boolean tight,int mask,int n){
        if(pos==n) return 1;
        
        int ans=0;
        for(int digit=0;digit<=9;digit++){
            boolean newTight=tight && (digit==9);

            if(mask==0 && digit==0){
               ans+=solve(pos+1,newTight,mask,n);
            }
            else{
                if((mask & (1<<digit))!=0) continue;

                int newMask=mask | (1<<digit);
                ans+=solve(pos+1,newTight,newMask,n);
            }
        }
        return ans;
    }
    public int countNumbersWithUniqueDigits(int n) {
        int mx=(int)Math.pow(10,n)-1;
        return solve(0,true,0,n);
    }
}
