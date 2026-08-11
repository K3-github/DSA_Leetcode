class Solution {
    public int waysToMakeFair(int[] nums) {
        int te=0,to=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i%2==0) te+=nums[i];
            else to+=nums[i];
        }
        int e=0,o=0;
        int ans=0;
        for(int i=0;i<n;i++){
            int re=te-e-(i%2==0 ? nums[i] : 0);
            int ro=to-o-(i%2==1 ? nums[i] : 0);

            if(e+ro==o+re) ans++;
            if(i%2==0) e+=nums[i];
            else o+=nums[i];
        }
        return ans;
    }
}