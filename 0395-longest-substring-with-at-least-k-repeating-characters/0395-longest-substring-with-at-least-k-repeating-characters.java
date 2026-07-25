class Solution {
    private int solve(int i,int j,String s,int k){
        HashMap<Character,Integer> freq=new HashMap<>();
        for(int ptr=i;ptr<=j;ptr++){
            char ch=s.charAt(ptr);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        for(int ptr=i;ptr<=j;ptr++){
            char ch=s.charAt(ptr);
            if(freq.get(ch)<k){
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