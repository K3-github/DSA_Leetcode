class Solution {
    private int getValue(char ch){
        if(ch=='A') return 0;
        if(ch=='C') return 1;
        if(ch=='G') return 2;
        return 3;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=s.length();
        int mask=(1<<20) - 1;
        int hash=0;
        List<String> ans= new ArrayList<>();
        for(int i=0;i<n;i++){
            hash= ((hash<<2) | getValue(s.charAt(i))) & mask;
            if(i>=9){
                int count=mp.getOrDefault(hash,0);
                if(count==1) ans.add(s.substring(i-9,i+1));
                mp.put(hash,count+1);
            }
        }
        return ans;
    }
}