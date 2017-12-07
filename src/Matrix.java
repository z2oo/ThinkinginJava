import java.util.Arrays;

/**
 * Created by Asus on 2017/10/24.
 */
public class Matrix {
    public static void main(String[] args){
        int[] p={10,5,2,8,4,9,10,7,6};
        int[][] m=new int[p.length][p.length];
        int[][] s=new int[p.length][p.length];
        matrixChain(p,m,s);
        System.out.println("最小连乘次数为："+m[1][p.length-1]);
        traceback(s,1,6);
    }

    public static void matrixChain(int[] p,int[][] m,int[][] s){
        int n=p.length-1;
        for(int i=0;i<=n;i++)
            m[i][i]=0;
        for(int r=2;r<=n;r++){
            for(int i=1;i<=n-r+1;i++){
                int j=i+r-1;
                m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];
                s[i][j]=i;
                for(int k=i+1;k<j;k++){
                    int t=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(t<m[i][j]){
                        m[i][j]=t;
                        s[i][j]=k;
                    }
                }
            }
        }
    }

    public static void traceback(int[][] s,int i,int j){
        if(i==j)return;
        traceback(s,i,s[i][j]);
        traceback(s,s[i][j]+1,j);
        System.out.println("Multiply A"+i+","+s[i][j]+"and A"+(s[i][j]+1)+","+j);
    }
}
