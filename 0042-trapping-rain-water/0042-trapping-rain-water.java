class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] pMax=new int[n];
        int[] sMax=new int[n];
        pMax[0]=height[0];
        for(int i=1;i<n;i++){
            pMax[i]=Math.max(pMax[i-1],height[i]);
        }
        sMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            sMax[i]=Math.max(sMax[i+1],height[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.min(pMax[i],sMax[i])-height[i];
        }
        return ans;
    }
}