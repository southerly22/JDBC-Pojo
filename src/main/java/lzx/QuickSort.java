package lzx;

import java.util.Arrays;

/***
 * @Author: lzx
 * @Description: java 快排
 * @Date: 2023/2/6
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {6,72,113,11,23};
        quickSort(a,0,a.length -1);
        System.out.println("快排结果：" + Arrays.toString(a));
    }
    //递归调用
    public static void quickSort(int[] array,int start,int end){
        if (start < end) //递归出口
        {
            int partition = partition(array, start, end); //中心位置
            //左区间
            quickSort(array,start,partition-1);
            quickSort(array,partition + 1,end);
        }
    }
    public static int partition(int[] array,int start,int end){
        int low = start;
        int high = array[end]; //选最后一个为中心元素

        for (int i = start; i < end; i++) {
            if (array[i] <= high){
                // i和low 换位置
                int tmp = array[i];
                array[i] = array[low];
                array[low] = tmp;
                low ++;
            }
            System.out.println(Arrays.toString(array));
        }
        //中心元素high和low换位置
        int tmp = array[low];
        array[low] = array[end];
        array[end] = tmp;

        return low;
    }
}
