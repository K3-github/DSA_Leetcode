class Node{
     Node[] links=new Node[26];
     boolean end=false;

     Node(){};
};
class Solution {
    private Node root=new Node();
    HashSet<String> st=new HashSet<>();
    List<String> ans=new ArrayList<>();
    private void insert(String word){
        Node node=root;
        for(char ch: word.toCharArray()){
            if(node.links[ch-'a']==null){
                node.links[ch-'a']=new Node();
            }
            node=node.links[ch-'a'];
        }
        node.end=true;
    }
    private void solve(int row,int col,Node node,String curr,char[][] board,boolean[][] vis){
         int n=board.length;
         int m=board[0].length;
         if(row<0 || row>=n || col<0 || col>=m || vis[row][col]==true) return;
         char ch=board[row][col];
         if(node.links[ch-'a']==null) return;

         vis[row][col]=true;
         curr+=ch;
         node=node.links[ch-'a'];
         if(node.end==true) st.add(curr);

         int[] drow=new int[]{0,+1,0,-1};
         int[] dcol=new int[]{+1,0,-1,0};

         for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            solve(nrow,ncol,node,curr,board,vis);
         }
         vis[row][col]=false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(String word: words){
            insert(word);
        }
        int n=board.length;
        int m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 Node node=root;
                 char ch=board[i][j];
                 if(node.links[ch-'a']!=null){
                    solve(i,j,node,"",board,vis);
                 }
            }
        }
        for(String str: st) ans.add(str);
        return ans;
    }
}