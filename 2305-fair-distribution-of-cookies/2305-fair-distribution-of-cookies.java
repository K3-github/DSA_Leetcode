class Solution {
    private boolean solve(int ind,int[] cookies,int[] children,int limit){
        if(ind==cookies.length) return true;
        for(int i=0;i<children.length;i++){
            if(children[i]+cookies[ind]>limit) continue;
            children[i]+=cookies[ind];
            if(solve(ind+1,cookies,children,limit)){
                return true;
            }
            children[i]-=cookies[ind];
            // if(children[i]==0) break;
        }
        return false;
    }

    public int distributeCookies(int[] cookies, int k) {
        int low=0,high=0;
        for(int x: cookies){
            low=Math.max(low,x);
            high+=x;
        }

        while(low<=high){
            int mid=low+(high-low)/2;

            int[] children=new int[k];

            if(solve(0,cookies,children,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return low;
    }
}