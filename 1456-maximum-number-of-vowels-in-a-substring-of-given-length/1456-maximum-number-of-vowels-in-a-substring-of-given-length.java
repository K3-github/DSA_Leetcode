class Solution {
    private boolean isVowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
    public int maxVowels(String s, int k) {
        int i=0,j=0,n=s.length();
        int ans=0;
        int vw=0;
        while(j<n){
            char ch=s.charAt(j);
            if(isVowel(ch)) vw++;
            if(j-i+1<k) j++;
            else if(j-i+1==k){
                ans=Math.max(ans,vw);
                ch=s.charAt(i);
                if(isVowel(ch)) vw--;
                i++;j++;
            }
        }
        return ans;
    }
}