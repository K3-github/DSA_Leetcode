class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int lMax=0;
        int[] sMax=new int[n];
        sMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            sMax[i]=Math.max(sMax[i+1],height[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            lMax=Math.max(lMax,height[i]);
            ans+=Math.min(lMax,sMax[i])-height[i];
        }
        return ans;
    }
}