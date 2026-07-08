class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length();
        int mod=1000000007;
        long[] pow=new long[n+1];
        pow[0]=1;
        for(int i=1;i<=n;i++){
            pow[i]=(pow[i-1]*10)%mod;
        }
        int[][] pfx=new int[n][3];
        long cn=0;
        int nod=0,sod=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch>='1' && ch<='9'){
                cn=((cn*10)%mod+(ch-'0'))%mod;
                nod++;sod+=(ch-'0');
            }
            pfx[i]=new int[]{(int)cn,nod,sod};
        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];

            int rn=pfx[r][0],ln=(l>0 ? pfx[l-1][0] : 0);
            int rd=pfx[r][1],ld=(l>0 ? pfx[l-1][1] : 0);
            int rs=pfx[r][2],ls=(l>0 ? pfx[l-1][2] : 0);

            int wd=rd-ld;
            long power=pow[wd]%mod;

            long wn = ((long)rn - (((long)ln * power) % mod) + mod) % mod;
            int ws=rs-ls;

            long wres=((wn%mod)*(long)ws%mod)%mod;
            ans[i]=(int)wres;
        }
        return ans;
    }
}