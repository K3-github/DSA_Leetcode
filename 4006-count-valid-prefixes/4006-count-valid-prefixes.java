class Solution {
    public int countValidPrefixes(String s) {
        int count=0;
        int zero=0,one=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='1') one++;
            else zero++;
            if(Math.abs(one-zero)<=1) count++;
        }
        return count;
    }
}