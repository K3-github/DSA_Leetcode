class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> mp=new HashMap<>();
        int n=s.length();
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        List<String> ans=new ArrayList<>();
        while(j<n){
            char ch=s.charAt(j);
            sb.append(ch);
            if(j-i+1==10){
                String str=sb.toString();
                if(mp.containsKey(str) && mp.get(str)==1) ans.add(str);
                mp.put(str,mp.getOrDefault(str,0)+1);
                sb.deleteCharAt(0);
                i++;
            }
            j++;
        }
        return ans;
    }
}