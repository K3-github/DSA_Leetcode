class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n];
        for(int i=0;i<n;i++) temp[i]=nums[i];
        Arrays.sort(temp);
        int i=0,j=n-1;
        while(j>0 && nums[j]==temp[j]) j--;
        while(i<=j && nums[i]==temp[i]) i++;
        if(j==0) return 0;
        return j-i+1;
    }
}