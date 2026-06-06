class Solution {
    private int solve(int ind,int curr,int target,int[] nums,HashMap<String,Integer> dp){
        if(ind<0){
            return curr==target ? 1 : 0;
        }
        String key=ind + "," + curr;
        if(dp.containsKey(key)) return dp.get(key);

        int w1=solve(ind-1,curr+nums[ind],target,nums,dp);
        int w2=solve(ind-1,curr-nums[ind],target,nums,dp);
        dp.put(key,w1+w2);
        return dp.get(key);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        HashMap<String,Integer> dp=new HashMap<>();
        return solve(n-1,0,target,nums,dp);
    }
}