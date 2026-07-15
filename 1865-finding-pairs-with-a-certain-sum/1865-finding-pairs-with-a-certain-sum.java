class FindSumPairs {
    int[] n1;
    HashMap<Integer,Integer> mpInd=new HashMap<>();
    HashMap<Integer,Integer> mpFreq=new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        n1=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            n1[i]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            mpFreq.put(nums2[i],mpFreq.getOrDefault(nums2[i],0)+1);
            mpInd.put(i,nums2[i]);
        }
    }
    
    public void add(int index, int val) {
        int curr=mpInd.get(index);
        mpFreq.put(curr,mpFreq.get(curr)-1);
        if(mpFreq.get(curr)==0) mpFreq.remove(curr);
        mpFreq.put(curr+val,mpFreq.getOrDefault(curr+val,0)+1);
        mpInd.put(index,curr+val);
    }
    
    public int count(int tot) {
        int count=0;
        for(int i=0;i<n1.length;i++){
            int req=tot-n1[i];
            if(mpFreq.containsKey(req)){
                count+=mpFreq.get(req);
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */