class Solution {
    public int countCompleteSubarrays(int[] nums) {
          HashMap<Integer,Integer> mp=new HashMap<>();
          for(int n: nums) mp.put(n,mp.getOrDefault(n,0)+1);
          int unique=mp.size();
          mp.clear();
          int i=0,j=0,count=0;
          int n=nums.length;
          while(j<n){
               mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
               while(i<=j && mp.size()==unique){
                    count+=n-j;
                    mp.put(nums[i],mp.get(nums[i])-1);
                    if(mp.get(nums[i])==0) mp.remove(nums[i]);
                    i++;
               }
               j++;
          }
          return count;
    }
}