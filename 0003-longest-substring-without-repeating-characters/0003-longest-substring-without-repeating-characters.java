class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int i=0,j=0;
        int n=s.length();
        
        int ans=0;
        while(j<n){
            char ch=s.charAt(j);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            
            while(j-i+1>mp.size()){
                char ch1=s.charAt(i);
                mp.put(ch1,mp.get(ch1)-1);
                if(mp.get(ch1)==0) mp.remove(ch1);
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}