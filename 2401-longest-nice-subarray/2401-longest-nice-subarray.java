class Solution {
    private boolean isValid(int[] freq,int ele){
        for(int i=31;i>=0;i--){
            int bit=(ele>>i)&1;
            if(bit==1 && freq[i]>0) return false;
        }
        return true;
    }
    private void removeLeft(int[] freq,int leftEle){
        for(int i=31;i>=0;i--){
            int bit=(leftEle>>i)&1;
            if(bit==1) freq[i]--;
        }
    }
    private void addRight(int[] freq,int rightEle){
        for(int i=31;i>=0;i--){
            int bit=(rightEle>>i)&1;
            if(bit==1) freq[i]++;
        }
    }
    public int longestNiceSubarray(int[] nums) {
        int left=0,right=0,ans=0;
        int[] freq=new int[32];
        int n=nums.length;
        while(right<n){
            while(left<n && !isValid(freq,nums[right])){
                 removeLeft(freq,nums[left]);
                 left++;
            }
            addRight(freq,nums[right]);
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}