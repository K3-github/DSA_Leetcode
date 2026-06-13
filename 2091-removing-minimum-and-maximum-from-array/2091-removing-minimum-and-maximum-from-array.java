class Solution {
    public int minimumDeletions(int[] nums) {
        int mn=100001,mx=-100001;
        int n=nums.length;
        int ind1=-1,ind2=-1;
        for(int i=0;i<n;i++){
            if(nums[i]<mn){
                mn=nums[i];
                ind1=i;
            }
            if(nums[i]>mx){
                mx=nums[i];
                ind2=i;
            }
        }
        int l1=ind1,l2=ind2;
        if(ind1>ind2){
            l1=ind2;l2=ind1;
        }
        int w1=l2+1;
        int w2=l1+1+n-l2;
        int w3=n-l1;
        return Math.min(w1,Math.min(w2,w3));
    }
}