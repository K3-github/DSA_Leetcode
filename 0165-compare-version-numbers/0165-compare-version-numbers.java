class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0,j=0;
        int n=version1.length();
        int m=version2.length();
        while(i<n && j<m){
            int v1=0;
            while(i<n && version1.charAt(i)!='.'){
                int dig=version1.charAt(i)-'0';
                v1=v1*10+dig;
                i++;
            }
            int v2=0;
            while(j<m && version2.charAt(j)!='.'){
                int dig=version2.charAt(j)-'0';
                v2=v2*10+dig;
                j++;
            }
            if(v1<v2) return -1;
            else if(v1>v2) return 1;
            i++;j++;
        }
        while(i<n){
            int v1=0;
            while(i<n && version1.charAt(i)!='.'){
                int dig=version1.charAt(i)-'0';
                v1=v1*10+dig;
                i++;
            }
            if(v1>0) return 1;
            i++;
        }
        while(j<m){
            int v2=0;
            while(j<m && version2.charAt(j)!='.'){
                int dig=version2.charAt(j)-'0';
                v2=v2*10+dig;
                j++;
            }
            if(v2>0) return -1;
            j++;
        }
        return 0;
    }
}