class Solution {
    private int bsRight(int[] ages,int x,int ind){
         int low=ind,high=ages.length-1;
         while(low<=high){
            int mid=(low+high) >> 1;
            if(ages[mid]<=x){
                low=mid+1;
            }
            else high=mid-1;
         }
         return high;
    }
    private int bsLeft(int[] ages,int x,int ind){
         int low=0,high=ages.length-1;
         while(low<=high){
            int mid=(low+high) >> 1;
            if(ages[mid]>x){
                high=mid-1;
            }
            else low=mid+1;
         }
         return low;
    }
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n=ages.length;
        int count=0;
        for(int i=0;i<n;i++){
            int x=ages[i];
            int left=bsLeft(ages,(x/2)+7,i);
            int right=bsRight(ages,x,i);
            if(right>=left) count+=right-left;
        }
        return count;
    }
}