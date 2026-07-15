class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long count=0;
        int n=rectangles.length;
        HashMap<Double,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            double r2=(double)rectangles[i][0]/rectangles[i][1];
            if(mp.containsKey(r2)){
                count+=mp.get(r2);
            }
            mp.put(r2,mp.getOrDefault(r2,0)+1);
        }
        return count;
    }
}