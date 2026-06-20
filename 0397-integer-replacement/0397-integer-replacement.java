class Solution {
    private int solve(long num){
        if(num==1) return 0;
        if(num<1) return 1000000;

        if(num%2==0){
            return 1+solve(num/2);
        }
        else{
            return 1+Math.min(solve(num-1),solve(num+1));
        }
    }
    public int integerReplacement(int n) {
        long num=n;
        return solve(num);
    }
}