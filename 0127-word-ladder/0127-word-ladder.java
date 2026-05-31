class Pair{
    String first;
    int second;

    Pair(String first, int second){
        this.first=first;
        this.second=second;
    }
};
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st=new HashSet<>();
        for(String str: wordList){
            st.add(str);
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        if(st.contains(beginWord)) st.remove(beginWord);

        while(!q.isEmpty()){
            Pair p=q.poll();
            String w=p.first;
            if(w.equals(endWord)) return p.second;

            char[] arr=w.toCharArray();
            for(int i=0;i<arr.length;i++){
                char org=arr[i];
                for(char ch='a';ch<='z';ch++){
                     arr[i]=ch;
                     String newWord=new String(arr);
                     if(st.contains(newWord)){
                        q.offer(new Pair(newWord,p.second+1));
                        st.remove(newWord);
                     }
                }
                arr[i]=org;
            }
        }
        return 0;
    }
}