class Solution {
    private boolean solve(String word,String s){
        int n=word.length(),m=s.length();
        int i=0,j=0;
        while(i<n && j<m){
            char ch1=word.charAt(i);
            char ch2=s.charAt(j);
            if(ch1==ch2){
                i++;j++;
            }
            else{
                j++;
            }
        }
        if(i==n) return true;
        return false;
    }
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String,Boolean> mp=new HashMap<>();
        int count=0;
        for(String word: words){
            if(mp.containsKey(word)){
                if(mp.get(word)) count++;
            }
            else{
                boolean res=solve(word,s);
                mp.put(word,res);
                if(res) count++;
            }
        }
        return count;
    }
}