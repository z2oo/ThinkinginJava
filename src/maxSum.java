import java.util.Arrays;

/**
 * Created by Asus on 2017/10/24.
 */
public class maxSum {
    public static void main(String[] args){
        int[] a={-2,11,-4,13, -5, -2};
        int max=sum(a);
        System.out.print(max);
    }

    public static int sum(int[] a){
        int length=a.length;
        int[] m=new int[length];
        m=a;
        for(int i=0;i<length-1;i++){
            if(m[i]+a[i+1]>m[i+1]) {
                m[i + 1] = m[i] + a[i + 1];
            }
        }
        int max=m[0];
        for(int i=1;i<length;i++){
            if(m[i]>max)
                max=m[i];
        }
        return max;
    }


}
