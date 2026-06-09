class Solution {
    private int findLowerBound(List<Integer> arr,int x){
        int n=arr.size();
        if(arr.get(0)>=x) return 0;
        if(arr.get(n-1)<x) return n;
        int low=0,high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr.get(mid)>=x){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> vec=new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(vec.size()==0){
                vec.add(nums[i]);
            }
            else{
                int ind=findLowerBound(vec,nums[i]);
                if(ind==vec.size()) vec.add(nums[i]);
                else vec.set(ind,nums[i]);
            }
        }
        return vec.size();
    }
}