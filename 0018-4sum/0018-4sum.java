class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> st=new HashSet<>();

        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                long req=(long)target-nums[i]-nums[j];
                int low=j+1,high=n-1;
                while(low<high){
                     long sum=nums[low]+nums[high];
                     if(sum==req){
                        List<Integer> ls=new ArrayList<>();
                            ls.add(nums[i]);
                            ls.add(nums[j]);
                            ls.add(nums[low]);
                            ls.add(nums[high]);

                            ans.add(ls);
                            low++;high--;
                            while(low<high && nums[low]==nums[low-1]) low++;
                            while(low<high && nums[high]==nums[high+1]) high--;
                     }
                     else if(sum<req) low++;
                     else high--;
                }
            }
        }
        return ans;
    }
}

// -2 -1 0 0 1 2