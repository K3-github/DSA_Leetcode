class Solution {
    private boolean isValid(List<Integer> curr,int k){
         HashMap<Integer,Integer> mp=new HashMap<>();
         for(int i=0;i<curr.size();i++){
             int req1=curr.get(i)-k;
             int req2=curr.get(i)+k;
             if(mp.containsKey(req1) || mp.containsKey(req2)) return false;
             mp.put(curr.get(i),mp.getOrDefault(curr.get(i),0)+1);
         }
         return true;
    }
    private int solve(int ind,int n,int k,List<Integer> curr,int[] nums){
        if(ind>=n){
            if(curr.size()>0 && isValid(curr,k)==true) return 1;
            return 0;
        }
        curr.add(nums[ind]);
        int w1=solve(ind+1,n,k,curr,nums);
        curr.remove(curr.size()-1);
        int w2=solve(ind+1,n,k,curr,nums);
        return w1+w2;
    }
    public int beautifulSubsets(int[] nums, int k) {
        List<Integer> curr=new ArrayList<>();
        int n=nums.length;
        return solve(0,n,k,curr,nums);
    }
}