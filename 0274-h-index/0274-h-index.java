class Solution {
    private boolean isPossible(int[] cit,int ele){
        int tot=0;
        for(int i=0;i<cit.length;i++){
            if(cit[i]>=ele) tot++;
        }
        return tot>=ele;
    }
    public int hIndex(int[] citations) {
        int low=0,high=1001;
        while(low<=high){
            int h=(low+high) >> 1;
            if(isPossible(citations,h)==true){
                low=h+1;
            }
            else high=h-1;
        }
        return high;
    }
}