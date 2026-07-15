class Solution {
    private int binarySearch(List<Integer> nums,int x,int ind){
        int low=ind,high=nums.size()-1;
        int ans=-1;
        while(low<=high){
             int mid=(low+high) >> 1;
             if(nums.get(mid)<x){
                ans=mid;
                low=mid+1;
             }
             else high=mid-1;
        }
        return ans;
    }
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n=nums.size();
        int count=0;
        for(int i=0;i<n;i++){
            int lastInd=binarySearch(nums,target-nums.get(i),i+1);
            if(lastInd!=-1) count+=lastInd-i;
        }
        return count;
    }
}