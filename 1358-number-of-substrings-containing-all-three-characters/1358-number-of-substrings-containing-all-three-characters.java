class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int i=0,j=0;
        int count=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        while(j<n){
             char ch=s.charAt(j);
             mp.put(ch,mp.getOrDefault(ch,0)+1);
             while(mp.size()==3){
                count+=(n-j);
                char ch1=s.charAt(i);
                mp.put(ch1,mp.get(ch1)-1);
                if(mp.get(ch1)==0) mp.remove(ch1);
                i++;
             }
             j++;
        }
        return count;
    }
}