class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        for(char ch: t.toCharArray()) mp.put(ch,mp.getOrDefault(ch,0)+1);
        int count=mp.size();
        int i=0,j=0,ans=Integer.MAX_VALUE;
        int start=-1,end=-1;
        while(j<n){
             char ch=s.charAt(j);
             if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)==0) count--;
             }
             while(i<=j && count==0){
                if(ans>j-i+1){
                   start=i;end=j;
                   ans=j-i+1;
                }
                char ch1=s.charAt(i);
                if(mp.containsKey(ch1)){
                    if(mp.get(ch1)==0) count++;
                    mp.put(ch1,mp.get(ch1)+1);
                }
                i++;
             }
             j++;
        }
        if(start==-1) return "";
        return s.substring(start,end+1);
    }
}