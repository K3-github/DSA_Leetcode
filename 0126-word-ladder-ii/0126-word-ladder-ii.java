class Solution {
    List<List<String>> ans=new ArrayList<>();
    HashMap<String,Integer> mp=new HashMap<>();
    private void dfs(int no,List<String> path){
        if(no==0){
            Collections.reverse(path);
            ans.add(path);
            return;
        }
        String word=path.get(path.size()-1);

        char[] arr=word.toCharArray();

        for(int i=0;i<arr.length;i++){
            char org=arr[i];
            for(char ch='a';ch<='z';ch++){
                if(ch == org) continue;
                arr[i]=ch;
                String newWord=new String(arr);
                if(mp.containsKey(newWord) && mp.get(newWord)==no-1){
                    List<String> temp=new ArrayList<>(path);
                    temp.add(newWord);
                    dfs(no-1,temp);
                }
            }
            arr[i]=org;
        }
        return;
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st=new HashSet<>();
        for(String str: wordList){
            st.add(str);
        }
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        if(st.contains(beginWord)) st.remove(beginWord);
        mp.put(beginWord,0);
        boolean found=false;
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<String> newWords=new ArrayList<>();
            for(int i=0;i<size;i++){
                String w=q.poll();
                int steps=mp.get(w);
                if(w.equals(endWord)){
                    found=true;
                }

                char[] arr=w.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char org=arr[j];
                    for(char ch='a';ch<='z';ch++){
                        arr[j]=ch;
                        String newWord=new String(arr);
                        if(st.contains(newWord)){
                            q.offer(newWord);
                            mp.putIfAbsent(newWord,steps+1);
                            st.remove(newWord);
                        }
                    }
                    arr[j]=org;
                }
            }
            if(found==true) break;
        }
        if(!mp.containsKey(endWord)){
           return new ArrayList<>();
        }
        int tNo=mp.get(endWord);
        List<String> path=new ArrayList<>();
        path.add(endWord);
        dfs(tNo,path);
        return ans;
    }
}