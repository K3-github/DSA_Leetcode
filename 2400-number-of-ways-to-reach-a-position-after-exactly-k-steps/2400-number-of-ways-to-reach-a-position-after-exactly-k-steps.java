class Solution {
    int mod=1000000007;
    private int solve(int pos,int k,int target,HashMap<String,Integer> dp){
        if(k==0){
            return pos==target ? 1 : 0;
        }
        String key=pos+":"+k;
        if(dp.containsKey(key)) return dp.get(key);
        long ans=0;
        ans+=solve(pos-1,k-1,target,dp);
        ans+=solve(pos+1,k-1,target,dp);
        dp.put(key,(int)(ans%mod));
        return dp.get(key);
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        HashMap<String,Integer> dp=new HashMap<>();
        return solve(startPos,k,endPos,dp);
    }
}