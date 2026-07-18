class Pair{
    int ts;
    String val;

    Pair(int ts,String val){
        this.ts=ts;
        this.val=val;
    }
};
class TimeMap {
    HashMap<String,List<Pair>> mp=new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> currLs=mp.get(key);
        if(currLs==null){
            mp.put(key,new ArrayList<>());
        }
        mp.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> ls=mp.get(key);
        if(ls==null) return "";
        int low=0,high=ls.size()-1;
        if(ls.get(high).ts<=timestamp) return ls.get(high).val;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(ls.get(mid).ts>timestamp) high=mid-1;
            else low=mid+1;
        }
        if(high<0) return "";
        return ls.get(high).val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */