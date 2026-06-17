class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] cand=new int[n];
        for(int i=0;i<n;i++) cand[i]=1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                cand[i]=1+cand[i-1];
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && cand[i]<=cand[i+1]){
                cand[i]=1+cand[i+1];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++) ans+=cand[i];
        return ans;
    }
}