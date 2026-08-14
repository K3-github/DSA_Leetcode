class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n=nums1.length;
        int m=nums2.length;
        int p=nums3.length;
        int q=nums4.length;
        int ans=0;
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int target=0-nums1[i]-nums2[j];
                int left=0,right=q-1;
                while(left<p && right>=0){
                    int sum=nums3[left]+nums4[right];
                    if(sum==target){
                        int noLeft=1;
                        while(left<p-1 && nums3[left]==nums3[left+1]){
                            noLeft++;left++;
                        }
                        int noRight=1;
                        while(right>0 && nums4[right]==nums4[right-1]){
                            noRight++;right--;
                        }
                        ans+=noLeft*noRight;
                        left++;right--;
                    }
                    else if(sum<target) left++;
                    else right--;
                }
            }
        }
        return ans;
    }
}