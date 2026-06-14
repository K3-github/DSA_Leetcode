class Solution {
    public int maxResult(int[] nums,int k) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[n-1]=nums[n-1];
        Deque<Integer> dq=new LinkedList<>();
        dq.offer(n-1);
        for(int i=n-2;i>=0;i--){
            while(!dq.isEmpty()&&dq.peekFirst()>i+k){
                dq.pollFirst();
            }
            dp[i]=nums[i]+dp[dq.peekFirst()];
            while(!dq.isEmpty()&&dp[dq.peekLast()]<=dp[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return dp[0];
    }
}