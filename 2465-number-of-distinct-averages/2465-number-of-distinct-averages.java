class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Double> st=new HashSet<>();
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while(i<j){
            double avg=(nums[i]+nums[j])/2.0;
            st.add(avg);
            i++;j--;
        }
        return st.size();
    }
}