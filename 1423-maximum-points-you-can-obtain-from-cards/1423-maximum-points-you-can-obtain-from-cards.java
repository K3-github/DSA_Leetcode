class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int i=n-k;
        int sum=0,ans=0;
        while(i<n){
            sum+=cardPoints[i++];
            ans=Math.max(ans,sum);
        }
        if(n-k==0) return sum;
        i=n-k;
        int j=0;
        while(i<n){
            sum=sum-cardPoints[i++]+cardPoints[j++];
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}