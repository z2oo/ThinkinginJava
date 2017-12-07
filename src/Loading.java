import java.util.Arrays;

/**
 * Created by Asus on 2017/11/21.
 */
public class Loading {
    public static float loading(float c, float [] w, int [] x) {
        int n = w.length;
        Element[] d = new Element[n];
        for (int i = 0; i < n; i++)
            d[i] = new Element(w[i], i);
        quickSort(d, 0, n - 1);
        float opt = 0;
        for (int i = 0; i < n; i++) x[i] = 0;
        for (int i = 0; i < n && d[i].w <= c; i++) {
            x[d[i].i] = 1;
            opt += d[i].w;
            c -= d[i].w;
        }
        return opt;
    }

    public static void main(String[] args){
        float[] w={4,3,1,2,3};
        float c=6;
        int[] x=new int[w.length];
        System.out.println("集装箱的体积分别为：");
        for(int i=0;i<w.length;i++){
            System.out.print(w[i]+" ");
        }
        System.out.println();
        loading(c,w,x);
        System.out.println("可以将以下的号数的集装箱放入船上，使得集装箱的数量最多：");
        for(int i=0;i<w.length;i++){
            if(x[i]==1)
                System.out.print((i+1)+" ");
        }

    }
    private static void quickSort(Element[] list, int first, int last) {
        if (last > first) {			//长度大于1
            int pivotIndex = partition(list, first, last);	//将list一分为二，pivotIndex为主元位置
            quickSort(list, first, pivotIndex - 1);		//对左数组递归排序
            quickSort(list, pivotIndex + 1, last);		//对右数组递归排序
        }
    }

    private static int partition(Element[] list, int first, int last) {	//使用主元划分数组list[first...last]
        Element pivot = list[first]; //将子数组的第一个元素选为主元
        int low = first + 1; // low指向子数组中的第二个元素
        int high = last; // high指向子数组的最后一个元素

        while (high > low) {
            while (low <= high && list[low].compareTo(pivot)<=0)	//从左侧开始查找第一个大于主元的元素
                low++;
            while (low <= high && list[high].compareTo(pivot) > 0) //从右侧开始查找第一个小于或等于主元的元素
                high--;
            if (high > low) {				//交换这两个元素
                Element temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > first && list[high].compareTo(pivot) >= 0)
            high--;
        if (list[high].compareTo(pivot)<0) {	//如果主元被移动，方法返回将子数组分为两部分的主元的新下标，否则，返回原始下标
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }

}
class Element implements Comparable<Element>{
    float w;
    int i;
    public Element(float ww,int ii){
        w=ww;
        i=ii;
    }
    public int compareTo(Element x){
        float xw=x.w;
        return w<xw ? -1:w==xw ? 0:1;
    }
}
