class Solution {
    public int nextGreaterElement(int n) {
        char[] arr=String.valueOf(n).toCharArray();
        int pivot=-1;
        int len=arr.length;
        for(int i=len-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot==-1) return -1;
        for(int i=len-1;i>=0;i--){
            if(arr[i]>arr[pivot]){
                char tp=arr[i];
                arr[i]=arr[pivot];
                arr[pivot]=tp;
                break;
            }
        }
        int l=pivot+1,r=len-1;
        while(l<r){
            char tp=arr[l];
            arr[l]=arr[r];
            arr[r]=tp;
            l++;r--;
        }
        long ans=Long.parseLong(new String(arr));
        if(ans>Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
}