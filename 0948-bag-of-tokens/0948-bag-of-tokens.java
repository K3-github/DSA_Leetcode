class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n=tokens.length;
        int score=0,left=0,right=n-1;
        int ans=0;
        while(left<=right){
            while(left<n && power>=tokens[left]){
                power-=tokens[left];
                score++;left++;
                ans=Math.max(ans,score);
            }
            if(score>0){
                power+=tokens[right];
                right--;score--;
            }
            if(left<n && power<tokens[left]) return ans;
        }
        return ans;
    }
}