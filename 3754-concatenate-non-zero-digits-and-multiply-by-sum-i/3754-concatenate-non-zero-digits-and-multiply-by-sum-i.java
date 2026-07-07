class Solution {
    public long sumAndMultiply(int n) {
        String temp=String.valueOf(n);
        long ans=0;
        long sum=0;
        for(char ch: temp.toCharArray()){
            if(ch>='1' && ch<='9'){
                ans=ans*10+(ch-'0');
                sum+=(ch-'0');
            }
        }
        return sum*ans;
    }
}