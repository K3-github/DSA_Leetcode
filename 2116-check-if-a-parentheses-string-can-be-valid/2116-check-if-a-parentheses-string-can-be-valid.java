class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2==1) return false;
        int min=0,max=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            char val=locked.charAt(i);
            if(val=='0'){
                min--;
                max++;
            }
            else if(ch=='('){
                min++;
                max++;
            }
            else{
                min--;
                max--;
            }

            if(max<0) return false;
            if(min<0) min=0;
        }
        return min==0;
    }
}