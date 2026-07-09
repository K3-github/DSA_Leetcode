class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
         int n=landStartTime.length;
         int m=waterStartTime.length;
         int ans=Integer.MAX_VALUE;
         for(int i=0;i<n;i++){
             int st=landStartTime[i];
             int td=landDuration[i];
             for(int j=0;j<m;j++){
                int wst=waterStartTime[j];
                int wdt=waterDuration[j];
                if(st+td>wst){
                    ans=Math.min(ans,st+td+wdt);
                }
                else{
                    ans=Math.min(ans,wst+wdt);
                }
             }
         }
         for(int i=0;i<m;i++){
             int st=waterStartTime[i];
             int td=waterDuration[i];
             for(int j=0;j<n;j++){
                int wst=landStartTime[j];
                int wdt=landDuration[j];
                if(st+td>wst){
                    ans=Math.min(ans,st+td+wdt);
                }
                else{
                    ans=Math.min(ans,wst+wdt);
                }
             }
         }
         return ans;
    }
}