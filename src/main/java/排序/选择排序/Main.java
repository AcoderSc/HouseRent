package 排序.选择排序;

import java.util.Arrays;

public class Main {
    static int[] array = {2, 1, 4, 7, 2, 12, 7};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(array));
        System.out.println("~~~~~~~~~~~~~~~~");
        //第一轮：1 2 4,7,2,12,7
        //第二轮确定第二小的数字！
        for (int i = 0; i < array.length - 1; i++) {
            int minindex = i;
            int min = array[i];//先假设最小的是array[0]
            for (int j = i + 1; j < array.length; j++) {//内层循环用于确定每轮的最小值
                if (min > array[j]) {//说明假定的最小值不是最小的！
                    min = array[j];
                    minindex = j;//记录下标
                }
            }
            //将最小值放在arr[0]
            if (minindex != i) {
                array[minindex] = array[i];//进行交换
                array[i] = min;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}