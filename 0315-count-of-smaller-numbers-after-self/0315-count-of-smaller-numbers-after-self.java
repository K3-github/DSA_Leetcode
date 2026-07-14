class Solution {
    int[] ans;
    private void merge(int low,int mid,int high,int[][] v){
        int i=low,j=mid+1;
        int cnt=0;
        int[][] res=new int[high-low+1][2];
        int k=0;
        while(i<=mid && j<=high){
            if(v[i][0]>v[j][0]){
                res[k++]=new int[]{v[j][0],v[j][1]};
                j++;cnt++;
            }
            else{
                ans[v[i][1]]+=cnt;
                res[k++]=new int[]{v[i][0],v[i][1]};
                i++;
            }
        }
        while(i<=mid){
            res[k++]=new int[]{v[i][0],v[i][1]};
            ans[v[i][1]]+=cnt;
            i++;
        }
        while(j<=high){
            res[k++]=new int[]{v[j][0],v[j][1]};
            j++;
        }
        for(int ptr=low;ptr<=high;ptr++){
            v[ptr]=res[ptr-low];
        }
        return;
    }
    private void mergeSort(int low,int high,int[][] v){
        if(low>=high) return;

        int mid=(low+high) >> 1;
        mergeSort(low,mid,v);
        mergeSort(mid+1,high,v);
        merge(low,mid,high,v);
    }
    public List<Integer> countSmaller(int[] nums) {
         int n=nums.length;
         ans=new int[n];
         int[][] v=new int[n][2];
         for(int i=0;i<n;i++){
            v[i]=new int[]{nums[i],i};
         }
         mergeSort(0,n-1,v);
         List<Integer> result=new ArrayList<>();
         for(int i=0;i<n;i++){
            result.add(ans[i]);
         }
         return result;
    }
}