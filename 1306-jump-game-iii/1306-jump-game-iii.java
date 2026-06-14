class Solution {
    private boolean solve(int ind,int[] arr,int[] vis){
        int n=arr.length;
        if(ind<0 || ind>=n) return false;
        if(arr[ind]==0) return true;
        if(vis[ind]==1) return false;

        vis[ind]=1;
        boolean w1=solve(ind+arr[ind],arr,vis);
        boolean w2=solve(ind-arr[ind],arr,vis);
        
        vis[ind]=0;
        return w1 || w2;
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        int[] vis=new int[n];
        return solve(start,arr,vis);
    }
}