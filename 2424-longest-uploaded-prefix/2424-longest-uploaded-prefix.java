class LUPrefix {
    boolean[] uploaded;
    int ptr=1;
    public LUPrefix(int n) {
        uploaded=new boolean[n+1];
        ptr=1;
    }
    
    public void upload(int video) {
        uploaded[video]=true;
        while(ptr<uploaded.length && uploaded[ptr]==true){
            ptr++;
        }
    }
    
    public int longest() {
        return ptr-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */