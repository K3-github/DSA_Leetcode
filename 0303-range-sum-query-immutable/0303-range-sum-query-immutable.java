class NumArray {
    
    int[] psum;
    public NumArray(int[] nums) {
        int n=nums.length;
        psum=new int[n];
        psum[0]=nums[0];
        for(int i=1;i<n;i++){
            psum[i]=nums[i]+psum[i-1];
        }
    }
    public int sumRange(int left, int right) {
        return psum[right]-(left>0 ? psum[left-1] : 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */