class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashMap<String,Integer> mp=new HashMap<>();
        int n=words.length;
        String ans="";
        for(int i=0;i<n;i++){
            StringBuilder str=new StringBuilder();
            boolean present=true;
            for(int j=0;j<words[i].length()-1;j++){
                str.append(words[i].charAt(j));
                if(!mp.containsKey(str.toString())){
                    present=false;
                }
            }
            if(present==true){
                 if(ans.length()<words[i].length()){
                    ans=words[i];
                 }
            }
            mp.put(words[i],1);
        }
        return ans;
    }
}