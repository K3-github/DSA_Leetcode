class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (a,b) -> {
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }
            else{
                return Integer.compare(a[0],b[0]);
            }
        });
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int[] ss: reservedSeats){
            mp.computeIfAbsent(ss[0], k-> new ArrayList<>()).add(ss[1]);
        }
        int size=mp.size();
        int rem=n-size;
        int ans=0;
        for(Map.Entry<Integer,List<Integer>> e: mp.entrySet()){
            List<Integer> rrs=e.getValue();
            int gps = 0;
            boolean left = true;    
            boolean middle = true;  
            boolean right = true;   

            for(int s : rrs){
                if(s >= 2 && s <= 5) left = false;
                if(s >= 4 && s <= 7) middle = false;
                if(s >= 6 && s <= 9) right = false;
            }
            if(left && right) gps = 2;
            else if(left || middle || right) gps = 1;

            ans += gps;
        }
        return ans+rem*2;
    }
}