class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans="";
        int n=dictionary.size();
        Collections.sort(dictionary);
        for(int i=0;i<n;i++){
            int l=0,r=0;
            String str=dictionary.get(i);
            while(l<str.length() && r<s.length()){
                char ch1=str.charAt(l);
                char ch2=s.charAt(r);
                if(ch1==ch2){
                    l++;r++;
                }
                else r++;
            }
            if(l==str.length() && ans.length()<str.length()){
                ans=str;
            }
        }
        return ans;
    }
}