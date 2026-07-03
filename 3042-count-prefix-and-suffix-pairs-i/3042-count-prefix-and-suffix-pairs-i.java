class Solution {
    private boolean solve(String s1,String s2){
        int n=s1.length(),m=s2.length();
        if(n>m) return false;
        int i=0,j=0;
        while(i<n && j<m){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(j);
            if(ch1!=ch2) return false;
            i++;j++;
        }
        i=n-1;j=m-1;
        while(i>=0 && j>=0){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(j);
            if(ch1!=ch2) return false;
            i--;j--;
        }
        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int cnt=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                   if(solve(words[i],words[j])) cnt++;
            }
        }
        return cnt;
    }
}