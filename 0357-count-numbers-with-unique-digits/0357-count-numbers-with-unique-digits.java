class Solution {
    private int solve(int pos,int mask,int n){
        if(pos==n) return 1;
    
        int ans=0;
        for(int digit=0;digit<=9;digit++){
            if(mask==0 && digit==0){
               ans+=solve(pos+1,mask,n);
            }
            else{
                if((mask & (1<<digit))!=0) continue;
                int newMask=mask | (1<<digit);
                ans+=solve(pos+1,newMask,n);
            }
        }
        return ans;
    }
    public int countNumbersWithUniqueDigits(int n) {
        return solve(0,0,n);
    }
}
