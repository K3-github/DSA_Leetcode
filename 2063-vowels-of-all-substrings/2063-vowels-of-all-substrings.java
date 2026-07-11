class Solution {
    private boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
    public long countVowels(String word) {
        int n=word.length();
        long ans=0,curr=0;
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            if(isVowel(ch)){
                curr+=i+1;
            }
            ans+=curr;
        }
        return ans;
    }
}