class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int[] freq=new int[26];
        int i=0,j=0;
        int maxF=0;
        int ans=0;
        while(j<n){
             char ch=s.charAt(j);
             freq[ch-'A']++;
             maxF=Math.max(maxF,freq[ch-'A']);
             
             if(j-i+1-maxF>k){
                char ch1=s.charAt(i);
                freq[ch1-'A']--;
                i++;
             }
             else ans=Math.max(ans,j-i+1);
             j++;
        }
        return ans;
    }
}