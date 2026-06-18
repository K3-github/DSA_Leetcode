class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n=asteroids.length;
        long m=(long)mass;
        for(int i=0;i<n;i++){
            if(m<asteroids[i]) return false;
            m+=asteroids[i];
        }
        return true;
    }
}