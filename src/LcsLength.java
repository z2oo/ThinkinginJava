/**
 * Created by Asus on 2017/11/7.
 */
public class LcsLength {
    public static int lesLength(char []x , char []y , int[][]b){
        int m = x.length-1;
        int n = y.length-1;
        int [][] c  = new int[m+1][n+1];
        for(int i = 1; i<=m ; i++){
            c[i][0] = 0;
        }
        for(int i = 1; i<=n ; i++){
            c[0][i] = 0;
        }
        for(int i = 1; i<=m ; i++){
            for(int j = 1; j<=n ; j++){
                if(x[i]==y[j]){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 1;
                }
                else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3;
                }
            }

        }
        return c[m][n];
    }

    public static void lcs (int i , int j , char []x ,int[][]b){
        if(i==0||j==0) return;
        if(b[i][j] == 1){
            lcs(i-1,j-1,x,b);
            System.out.print(x[i]);
        }
        else if(b[i][j] ==2) lcs(i-1,j,x,b);
        else lcs(i ,j-1,x,b);
    }

    public static void main(String[] args){
        char [] x = {'x','z','y','z','z','y','x'};
        char [] y = {'z','x','y','y','z','x','z'};
        int i = x.length-1;
        int j = y.length-1;
        int [][] b = new int[7][7];

        lesLength (x,y,b);
        lcs(i,j,x,b);

    }

}
