class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int leftSum=0,rightSum=0;
        int ans=0,j=n-1;
        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
            ans=Math.max(ans,leftSum);
        }
        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[j--];
            ans=Math.max(ans,leftSum+rightSum);
        }
        return ans;
    }
}