class Solution {
    public int maxDistinct(String s) {
        int dis=0;
        int[] f=new int[26];
        for(char ch: s.toCharArray()){
            f[ch-'a']++;
            if(f[ch-'a']==1) dis++;
        }
        return dis;
    }
}