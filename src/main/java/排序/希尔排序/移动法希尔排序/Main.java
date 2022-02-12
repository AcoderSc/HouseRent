package 排序.希尔排序.移动法希尔排序;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {3, 6, 1, 9, 3, 10, 5, 23};//希尔排序移位法
        //第一轮：
        for (int s = a.length / 2; s > 0; s /= 2) {
            for (int i = s; i < a.length; i++) {
                int insertindex = i;
                int insertVal = a[insertindex];
                while (insertindex-s >=0 && insertVal < a[insertindex-s]){
                    a[insertindex] = a[insertindex-s];
                    insertindex-=s;
                }
                a[insertindex] = insertVal;
            }
            System.out.print(s + " ");//
        }
        System.out.println();
        System.out.println(Arrays.toString(a));
    }
}
