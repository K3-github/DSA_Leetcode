class Solution {
    int count=0;
    private void merge(int low,int mid,int high,long[] psum,int lower,int upper){
        int start=mid+1;
        int end=mid+1;
        for(int i=low;i<=mid;i++){
            while(start<=high && psum[start]-psum[i]<lower){
                start++;
            }
            while(end<=high && psum[end]-psum[i]<=upper){
                end++;
            }
            count+=end-start;
        }
        int i=low,j=mid+1;
        long[] res=new long[high-low+1];
        int k=0;
        while(i<=mid && j<=high){
            if(psum[i]<=psum[j]) res[k++]=psum[i++];
            else res[k++]=psum[j++];
        }
        while(i<=mid){
            res[k++]=psum[i++];
        }
        while(j<=high){
            res[k++]=psum[j++];
        }
        for(int ptr=low;ptr<=high;ptr++){
            psum[ptr]=res[ptr-low];
        }
        return;
    }
    private void mergeSort(int low,int high,long[] psum,int lower,int upper){
        if(low>=high) return;

        int mid=(low+high) >> 1;
        mergeSort(low,mid,psum,lower,upper);
        mergeSort(mid+1,high,psum,lower,upper);
        merge(low,mid,high,psum,lower,upper);
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n=nums.length;
        long[] psum=new long[n+1];
        for(int i=0;i<n;i++){
            psum[i+1]=psum[i]+(long)nums[i];
        }
        mergeSort(0,n,psum,lower,upper);
        return count;
    }
}