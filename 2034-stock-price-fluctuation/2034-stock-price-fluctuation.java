class StockPrice {
    int ts=0;
    HashMap<Integer,Integer> mp=new HashMap<>();
    TreeMap<Integer,Integer> bs=new TreeMap<>();
    public StockPrice() {
        
    }
    
    public void update(int timestamp, int price) {
        ts=Math.max(ts,timestamp);
        if(mp.containsKey(timestamp)){
            int val=mp.get(timestamp);
            bs.put(val,bs.get(val)-1);
            if(bs.get(val)==0) bs.remove(val);
        }
        mp.put(timestamp,price);
        bs.put(price,bs.getOrDefault(price,0)+1);
    }
    
    public int current() {
        return mp.get(ts);
    }
    
    public int maximum() {
        return bs.lastKey();
    }
    
    public int minimum() {
        return bs.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */