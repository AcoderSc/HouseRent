package 排序.选择排序;

import java.util.Arrays;

public class 自己写的选择排序 {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 3, 7, 5, 2};
        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int minindex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (min > a[j]) {//找到最小值
                    min = a[j];
                    minindex = j;
                }
            }
            if (minindex != i) {
                a[minindex] = a[i];
                a[i] = min;
            }

        }
        System.out.println(Arrays.toString(a));
    }
}
