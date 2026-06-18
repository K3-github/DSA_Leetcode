class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<>();
        int i=0,j=0;
        while(j<n){
            while(dq.size()>0 && nums[dq.peekLast()]<=nums[j]){
                dq.pollLast();
            }
            dq.offerLast(j);
            if(j-i+1==k){
                ans.add(nums[dq.peekFirst()]);
                if(dq.peekFirst()==i) dq.pollFirst();
                i++;
            }
            j++;
        }
        int[] res=new int[ans.size()];
        for(int p=0;p<ans.size();p++){
            res[p]=ans.get(p);
        }
        return res;
    }
}