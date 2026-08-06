class Solution {
    public int smallestNumber(int n, int t) {
        int low=n,high=110;
        for(int num=low;num<=high;num++){
            int pro=1;
            int temp=num;
            while(temp!=0){
                pro*=(temp%10);
                temp/=10;
            }
            if(pro%t==0) return num;
        }
        return 110;
    }
}