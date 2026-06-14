class Solution {
    public boolean lemonadeChange(int[] bills) {
        int c5=0,c10=0;
        int n=bills.length;
        for(int i=0;i<n;i++){
             int num=bills[i];
             if(num==5){
                c5++;
             }
             else if(num==10){
                c10++;
                if(c5==0) return false;
                c5--;
             }
             else{
                if(c5==0) return false;
                else if(c10==0){
                    if(c5<3) return false;
                    c5-=3;
                }
                else{
                    c10--;
                    c5--;
                }
             }
        }
        return true;
    }
}