class Solution {
    int ans=0;
    private int solve(int root,int[] cost,int n){
        if(root>n) return 0;

        int left=solve(2*root,cost,n);
        int right=solve(2*root+1,cost,n);
        
        int mx=Math.max(left,right);
        ans+=2*mx-left-right;
        return cost[root-1]+mx;
    }
    public int minIncrements(int n, int[] cost) {
        int[] dp=new int[n];
        solve(1,cost,n);
        return ans;
    }
}