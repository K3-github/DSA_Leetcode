class Solution {
    private int solve(int low,int high){
        int noe=high-low+1;
        if(noe==0) return 1;
        if(noe==1 || noe==2) return noe;
        
        int ans=0;
        for(int i=low;i<=high;i++){
            int left=solve(low,i-1);
            int right=solve(i+1,high);
            ans+=left*right;
        }
        return ans;
    }
    public int numTrees(int n) {
        return solve(1,n);
    }
}