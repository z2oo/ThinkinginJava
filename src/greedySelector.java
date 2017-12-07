public class greedySelector {
    public static int greedySelector(int n,int[] s, int[] f, boolean a[]) {
        a[0] = true;
        int j = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] >= f[j]) {
                a[i] = true;
                j = i;
                count++;
            } else a[i] = false;
        }
        return count;
    }
    public static void main(String[] args){
        int n=11;
        boolean[] a=new boolean[n];
        int[] s={1,3,0,5,3,5,6,8,8,2,12};
        int[] f={4,5,6,7,8,9,10,11,12,13,14};
        System.out.println("活动最大安排数为"+greedySelector(n,s,f,a));
        System.out.println("分别为:");
        for(int i=0;i<a.length;i++){
            if(a[i]==true){
                System.out.print((i+1)+" ");
            }
        }
    }
}