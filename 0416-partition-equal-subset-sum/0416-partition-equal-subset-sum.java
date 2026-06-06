class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum%2!=0) return false;
        int req=sum/2;
        boolean[] prev=new boolean[req+1];
        for(int i=0;i<n;i++) prev[0]=false;
        if(nums[0]<=req){
            prev[nums[0]]=true;
        }
        for(int i=1;i<n;i++){
            boolean[] cur=new boolean[req+1];
            cur[0]=false;
            for(int curr=1;curr<=req;curr++){
                boolean w1=false;
                if(nums[i]<=curr) w1=prev[curr-nums[i]];
                boolean w2=prev[curr];
                cur[curr] = w1 || w2;
            }
            prev=cur;
        }
        return prev[req];
    }
}