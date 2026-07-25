class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ans=0;
        int n=answerKey.length();
        int left=0,right=0;
        int cnt=k;
        while(right<n){
            char ch=answerKey.charAt(right);
            if(ch=='F') cnt--;
            while(left<n && cnt<0){
                ch=answerKey.charAt(left);
                if(ch=='F') cnt++;
                left++;
            }
            ans=Math.max(ans,right-left+1);
            right++;
        }
        left=0;right=0;cnt=k;
        while(right<n){
            char ch=answerKey.charAt(right);
            if(ch=='T') cnt--;
            while(left<n && cnt<0){
                ch=answerKey.charAt(left);
                if(ch=='T') cnt++;
                left++;
            }
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}