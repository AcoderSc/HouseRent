package 排序.冒泡排序;

import java.util.Arrays;

public class Main {
    static int[] a = new int[]{2, 6, 1, 9, 3, 6, 10};

    public static void main(String[] args) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1-i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
    }

}
