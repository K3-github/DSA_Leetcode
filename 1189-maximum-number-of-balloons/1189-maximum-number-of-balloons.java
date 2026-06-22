class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] f=new int[26];
        for(char ch: text.toCharArray()) f[ch-'a']++;
        String str="balloon";
        int ans=100000;
        for(char ch: str.toCharArray()){
            if(ch=='l' || ch=='o'){
                ans=Math.min(ans,f[ch-'a']/2);
            }
            else ans=Math.min(ans,f[ch-'a']);
        }
        return ans;
    }
}