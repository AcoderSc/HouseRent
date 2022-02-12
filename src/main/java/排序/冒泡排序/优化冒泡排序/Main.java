package 排序.冒泡排序.优化冒泡排序;

import java.util.Arrays;

public class Main {
    static int[] a = new int[]{1,89,8989,90,12,43434,45,12,23,3323,76543,987654321,1234,90};
    public static void main(String[] args) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = false;//表明没有发生交换
            for (int j = 0; j < a.length - 1-i; j++) {
                if (a[j] > a[j + 1]) {
                    flag = true;//交换了，就为true
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }

            if (flag == false){
                break;
            }
            System.out.println(Arrays.toString(a));
        }
    }

}
