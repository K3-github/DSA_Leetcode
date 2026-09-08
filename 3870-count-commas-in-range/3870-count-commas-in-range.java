class Solution {
    private int count(int x){
        int count=0;
        while(x>0){
            count++;
            x/=10;
        }
        return count;
    }
    public int countCommas(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int digits=count(i);
            ans+=(digits-1)/3;
        }
        return ans;
    }
}
