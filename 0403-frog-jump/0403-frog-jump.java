class Solution {
    HashMap<Integer,Integer> mp=new HashMap<>();
    private int solve(int ind,int prevSteps,int target,int[] stones,int[][] dp){
        int n=stones.length;
        if(ind==n-1) return 1;
        if(dp[ind][prevSteps]!=-1) return dp[ind][prevSteps];

        int ans=0;
        if(prevSteps-1>0 && mp.containsKey(stones[ind]+prevSteps-1)){
         int res=solve(mp.get(stones[ind]+prevSteps-1),prevSteps-1,target,stones,dp);
         if(res==1) ans=1;
        }
        if(mp.containsKey(stones[ind]+prevSteps)){
         int res=solve(mp.get(stones[ind]+prevSteps),prevSteps,target,stones,dp);
         if(res==1) ans=1;
        }
        if(mp.containsKey(stones[ind]+prevSteps+1)){
         int res=solve(mp.get(stones[ind]+prevSteps+1),prevSteps+1,target,stones,dp);
         if(res==1) ans=1;
        }
        return dp[ind][prevSteps]=ans;
    }
    public boolean canCross(int[] stones) {
        int n=stones.length;
        if(stones[1]!=1) return false;
        int target=stones[n-1];
        for(int i=0;i<n;i++){
            mp.put(stones[i],i);
        }
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int ans= solve(1,1,target,stones,dp);
        return ans==0 ? false : true;
    }
}