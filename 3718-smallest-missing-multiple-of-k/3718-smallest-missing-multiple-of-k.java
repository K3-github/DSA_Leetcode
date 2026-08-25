class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> st=new HashSet<>();
        for(int num: nums) st.add(num);
        
        int mul=1;
        while(true){
            int uk=k*mul;
            if(!st.contains(uk)) return uk;
            mul++;
        }
    }
}