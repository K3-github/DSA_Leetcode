class Solution {
    private long rev(int x){
        long ans=0;
        while(x>0){
            ans=ans*10+(x%10);
            x/=10;
        }
        return ans;
    }
    public int countNicePairs(int[] nums) {
        HashMap<Long,Integer> mp=new HashMap<>();
        long count=0;
        int mod=1000000007;
        for(int i=0;i<nums.length;i++){
             Long req=(long)nums[i]-rev(nums[i]);
             if(mp.containsKey(req)){
                count=(count+mp.get(req))%mod;
             }
             mp.put(req,mp.getOrDefault(req,0)+1);
        }
        return (int)count;
    }
}