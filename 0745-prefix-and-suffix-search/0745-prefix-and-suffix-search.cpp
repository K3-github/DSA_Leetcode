struct Node{
    unordered_map<char,Node*> links;
    int ind;

    Node(){
        ind=-1;
    }
};
class WordFilter {
private:
      Node* root;
public:
    void insert(string &key,int ind){
       Node* node=root;
       for(auto ch: key){
          if(!node->links[ch]){
            node->links[ch]=new Node();
          }
          node=node->links[ch];
          node->ind=ind;
       }
    }
    WordFilter(vector<string>& words) {
         root=new Node();
         for(int index=0;index<words.size();index++){
            for(int i=0;i<=words[index].size();i++){
                string suf=words[index].substr(i);
                string key=suf+"#"+words[index];
                insert(key,index);
            }
         }
    }
    
    int f(string pref, string suff) {
        string key=suff+"#"+pref;
        Node* node=root;
        for(auto ch: key){
            if(!node->links[ch]) return -1;
            node=node->links[ch];
        }
        return node->ind;
    }
};

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter* obj = new WordFilter(words);
 * int param_1 = obj->f(pref,suff);
 */