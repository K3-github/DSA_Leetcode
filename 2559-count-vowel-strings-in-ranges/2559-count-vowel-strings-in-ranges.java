class Solution {
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    private boolean check(String str){
        int n=str.length();
        char f=str.charAt(0),l=str.charAt(n-1);
        return isVowel(f) && isVowel(l);
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int[] psum=new int[n+1];
        for(int i=0;i<n;i++){
            psum[i+1]=psum[i]+(check(words[i])==true ? 1 : 0);
        }
        int len=queries.length;
        int[] ans=new int[len];
        for(int i=0;i<len;i++){
            int l=queries[i][0],r=queries[i][1];
            ans[i]=psum[r+1]-psum[l];
        }
        return ans;
    }
}