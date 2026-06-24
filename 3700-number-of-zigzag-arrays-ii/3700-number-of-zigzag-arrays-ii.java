class Solution {
    int mod=1000000007;

    private long[][] multiply(long[][] a,long[][] b){
        int n=a.length;
        long[][] res=new long[n][n];
        for(int i=0;i<n;i++){
            for(int k=0;k<n;k++){
                if(a[i][k]==0) continue;
                for(int j=0;j<n;j++){
                    res[i][j]=(res[i][j]+a[i][k]*b[k][j])%mod;
                }
            }
        }
        return res;
    }
    private long[][] power(long[][] mat,long exp){
        int n=mat.length;
        long[][] res=new long[n][n];
        for(int i=0;i<n;i++){
            res[i][i]=1;
        }
        while(exp>0){
            if((exp&1)==1){
                res=multiply(res,mat);
            }
            mat=multiply(mat,mat);
            exp>>=1;
        }
        return res;
    }
    public int zigZagArrays(int n,int l,int r){
        int m=r-l+1;
        int size=2*m;

        long[][] trans=new long[size][size];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(j<i){
                    trans[(j-1)*2+1][(i-1)*2]=1;
                }
                if(j>i){
                    trans[(j-1)*2][(i-1)*2+1]=1;
                }
            }
        }

        long[][] start=new long[1][size];
        for(int i=0;i<size;i++){
            start[0][i]=1;
        }
        long[][] result=power(trans,n-1);
        long ans=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                ans=(ans+start[0][i]*result[i][j])%mod;
            }
        }
        return (int)ans;
    }
}