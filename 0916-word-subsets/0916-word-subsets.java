class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] required=new int[26];

        for(int i=0;i<words2.length;i++){
            int[] freq = new int[26];
            for(int j=0;j<words2[i].length();j++){
                char ch=words2[i].charAt(j);
                freq[ch-'a']++;
            }

            for(int j=0;j<26;j++){
                required[j]=Math.max(required[j],freq[j]);
            }
        }
        List<String> ans=new ArrayList<>();
        for(String word: words1){
            int[] freq = new int[26];
            for(int j=0;j<word.length();j++){
                char ch=word.charAt(j);
                freq[ch-'a']++;
            }
            boolean universal=true;
            for(int i=0;i<26;i++){
                if(required[i]>freq[i]){
                    universal=false;
                    break;
                }
            }
            if(universal) ans.add(word);
        }
        return ans;
    }
}