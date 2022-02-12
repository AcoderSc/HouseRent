package 排序.希尔排序.排序性能的测算;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        long t1 = date.getTime();
        int[] a = new int[80000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) Math.random() * 10000;
        }

        sort01(a);
        Date date2 = new Date();
        long t2 = date2.getTime();

        System.out.println("排序时间为：" + (t2-t1) + "ms");

    }

    public static void sort01(int[] a) {
        for (int s = a.length / 2; s > 0; s /= 2) {
            for (int i = s; i < a.length; i++) {
                for (int j = i - s; j >= 0; j -= s) {//步长为5
                    if (a[j] > a[j + s]) {
                        int temp = a[j];
                        a[j] = a[j + s];
                        a[j + s] = temp;
                    }
                }
            }
        }
        System.out.println();

    }


}
