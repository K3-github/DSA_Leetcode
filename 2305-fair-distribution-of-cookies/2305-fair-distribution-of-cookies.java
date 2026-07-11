class Solution {
    private boolean isPossible(int ind,int[] cookies,int mx,int[] children){
        if(ind==cookies.length) return true;

        for(int i=0;i<children.length;i++){
            if(children[i]+cookies[ind]>mx) continue;
            children[i]+=cookies[ind];
            if(isPossible(ind+1,cookies,mx,children)==true) return true;
            children[i]-=cookies[ind];
        }
        return false;
    }
    public int distributeCookies(int[] cookies, int k) {
        int low=0,high=0;
        int n=cookies.length;
        for(int i=0;i<n;i++){
            low=Math.max(low,cookies[i]);
            high+=cookies[i];
        }
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int[] children=new int[k];
            if(isPossible(0,cookies,mid,children)==true){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
}