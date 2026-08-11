class Solution {
    public int waysToMakeFair(int[] nums) {
        int n=nums.length;
        int[] podd=new int[n+1];
        int[] peven=new int[n+1];
        
        for(int i=0;i<n;i++){
            peven[i+1]=peven[i];
            podd[i+1]=podd[i];
            if(i%2==0){
                peven[i+1]=peven[i]+nums[i];
            }
            else{
                podd[i+1]=podd[i]+nums[i];
            }
        }
        int even=0,odd=0;
        int ans=0;
        for(int i=n-1;i>=0;i--){
             int teven=peven[i]+odd;
             int todd=podd[i]+even;
             if(teven==todd) ans++;

             if(i%2==0) even+=nums[i];
             else odd+=nums[i];
        }
        return ans;
    }
}