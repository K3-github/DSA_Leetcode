class Solution {
    public long maxStrength(int[] nums) {
        long pos=1;
        long neg=1;
        int negCount=0;
        int zeroCount=0;
        int posCount=0;
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
          if(nums[i]==0){
            zeroCount++;
            continue;
          }
          else if(nums[i]>0){
            pos*=nums[i];
            posCount++;
          }
          else{
            neg*=nums[i];
            negCount++;
          }
        }
        int firstNeg=1;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<0){
                firstNeg=nums[i];
                break;
            }
        }
        if(posCount==0){
            if(negCount==1){
                if(zeroCount!=0) return 0;
                return neg;
            } 
            else if(negCount==0) return 0;
            else if(negCount%2==0) return neg;
            else return neg/firstNeg;
        }
        if(negCount%2==0) return pos*neg;
        neg/=firstNeg;
        return pos*neg;
    }
}