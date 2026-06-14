class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int k=p.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        for(char ch:p.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int count=mp.size();
        int i=0,j=0;
        List<Integer> ans=new ArrayList<Integer>();
        while(j<n){
            char ch=s.charAt(j);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)==0) count--;
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(count==0) ans.add(i);
                char ch1=s.charAt(i);
                if(mp.containsKey(ch1)){
                    if(mp.get(ch1)==0) count++;
                    mp.put(ch1,mp.get(ch1)+1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}