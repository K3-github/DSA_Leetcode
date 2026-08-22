class Solution {
    public boolean checkDivisibility(int n) {
        int num=n;
        int digitSum=0,digitProd=1;

        while(num>0){
            int digit=num%10;
            digitSum+=digit;
            digitProd*=digit;
            num/=10;
        }
        int sum=digitSum+digitProd;
        return n%sum==0;
    }
}