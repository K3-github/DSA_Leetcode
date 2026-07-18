class Solution {
    private int bsearch(int[] nums,int x,int ind){
        int low=0,high=ind;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(nums[mid]>x) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                int x=nums[i]-nums[j];
                int leftMost=bsearch(nums,x,j-1);
                count+=j-leftMost;
            }
        }
        return count;
    }
}