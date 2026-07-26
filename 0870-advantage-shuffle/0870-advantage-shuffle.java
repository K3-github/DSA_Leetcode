class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int[][] v=new int[n][2];
        for(int i=0;i<n;i++){
            v[i]=new int[]{nums2[i],i};
        }
        Arrays.sort(v,(a,b) -> a[0] - b[0]);
        Arrays.sort(nums1);
        int[] ans=new int[n];
        int i=0,j=0;
        while(i<n){
            if(nums1[i]<=v[j][0]){
                i++;
            }
            else{
                ans[v[j][1]]=nums1[i];
                nums1[i]=-1;
                i++;j++;
            }
        }
        i=0;
        while(i<n){
            if(nums1[i]!=-1){
                ans[v[j][1]]=nums1[i];
                j++;
            }
            i++;
        }
        return ans;
    }
}