class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int n=s.length();
        
        int ans=0;
        int i=0;
        for(int j=0;j<n;j++){
            char ch=s.charAt(j);
            if(mp.containsKey(ch)){
              i=Math.max(i,mp.get(ch)+1);
            }
            mp.put(ch,j);
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }
}