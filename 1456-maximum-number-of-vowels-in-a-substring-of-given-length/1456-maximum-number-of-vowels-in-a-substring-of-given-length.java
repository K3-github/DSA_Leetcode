class Solution {
    public int maxVowels(String s, int k) {
        int i=0,j=0,n=s.length();
        int ans=0;
        int vw=0;
        while(j<n){
            char ch=s.charAt(j);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') vw++;
            if(j-i+1<k) j++;
            else if(j-i+1==k){
                ans=Math.max(ans,vw);
                ch=s.charAt(i);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') vw--;
                i++;j++;
            }
        }
        return ans;
    }
}