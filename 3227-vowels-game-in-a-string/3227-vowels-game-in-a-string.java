class Solution {
    private boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
        return false;
    }
    public boolean doesAliceWin(String s) {
        for(char c : s.toCharArray()){
            if(isVowel(c)) return true;
        }
        return false;
    }
}