class Solution {
    private int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public long gcdSum(int[] nums) {
        int mx=0,n=nums.length;
        int[] prefixGcd=new int[n];
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
            prefixGcd[i]=gcd(nums[i],mx);
        }
        Arrays.sort(prefixGcd);
        int i=0,j=n-1;
        long sum=0;
        while(i<j){
            sum+=gcd(prefixGcd[i],prefixGcd[j]);
            i++;j--;
        }
        return sum;
    }
}