class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        int n=nums.length;

        int left=0,right=0;
        long count=0;
        while(right<n){
            int currE=nums[right];
            int currF=freq.getOrDefault(currE,0);
            k=k-currF;
            freq.put(currE,currF+1);
            while(left<n && k<=0){
                count+=n-right;
                int prevE=nums[left];
                int leftEF=freq.get(prevE);
                k=k+leftEF-1;
                freq.put(prevE,leftEF-1);
                if(freq.get(prevE)==0) freq.remove(prevE);
                left++;
            }
            right++;
        }
        return count;
    }
}