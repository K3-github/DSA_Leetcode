class Solution {
    private int solve(int i,int j,String s,int k){
        if(i>j || j-i+1<k) return 0;
        int[] freq=new int[26];
        for(int ptr=i;ptr<=j;ptr++){
            char ch=s.charAt(ptr);
            freq[ch-'a']++;
        }
        for(int ptr=i;ptr<=j;ptr++){
            char ch=s.charAt(ptr);
            if(freq[ch-'a']<k){
                return Math.max(solve(i,ptr-1,s,k),solve(ptr+1,j,s,k));
            }
        }
        return j-i+1;
    }
    public int longestSubstring(String s, int k) {
        int n=s.length();
        return solve(0,n-1,s,k);
    }
}