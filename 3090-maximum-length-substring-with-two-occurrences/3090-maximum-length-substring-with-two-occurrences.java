class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int i=0,j=0;
        int[] f=new int[26];
        int ans=0;
        while(j<n){
            char right=s.charAt(j);
            f[right-'a']++;
            while(i<j && f[right-'a']>2){
                char left=s.charAt(i);
                f[left-'a']--;
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}