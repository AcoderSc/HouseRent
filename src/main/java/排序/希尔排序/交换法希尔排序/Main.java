package 排序.希尔排序.交换法希尔排序;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {3, 6, 1, 9, 3, 10, 5, 23};//希尔排序交换法
        sort01(a);
        //第一轮：

    }
    private static void sort01(int[] a) {
        for (int s = a.length / 2; s > 0; s /= 2) {
            for (int i = s; i < a.length; i++) {
                for (int j = i - s; j >= 0; j -= s) {//步长为5
                    if (a[j] > a[j + s]) {//交换
                        int temp = a[j];
                        a[j] = a[j + s];
                        a[j + s] = temp;
                    }
                }
            }
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(a));
    }
}
