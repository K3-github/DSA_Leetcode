class Solution {
    private boolean solve(int i,int j,String s,String p){
        if(j<0) return i<0;
        if(i<0){
            while(j>=1 && p.charAt(j)=='*'){
                j-=2;
            }
            return j<0;
        }

        char ch1=s.charAt(i);
        char ch2=p.charAt(j);

        if(ch1==ch2 || ch2=='.'){
            return solve(i-1,j-1,s,p);
        }
        if(ch2=='*'){
            boolean zero = solve(i, j - 2, s, p);
            boolean oneOrMore = false;
            char prev = p.charAt(j-1);
            if(prev == '.' || prev == ch1) {
                oneOrMore = solve(i - 1, j, s, p);
            }
            return zero || oneOrMore;
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        return solve(n-1,m-1,s,p);
    }
}