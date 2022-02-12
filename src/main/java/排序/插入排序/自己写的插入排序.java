package 排序.插入排序;

import java.util.Arrays;

public class 自己写的插入排序 {
    public static void main(String[] args) {
        int[] a = {1, 2, 7, 4, 5};
        for (int i = 1; i < a.length; i++) {
            int insertVal = a[i];//插入的数字
            int insertindex = i - 1;//
            while (insertindex >= 0 && insertVal < a[insertindex]) {
                a[insertindex + 1] = a[insertindex];
                insertindex -- ;
            }
            if (insertindex + 1 != i) {//判断需不需要赋值
                a[insertindex + 1] = insertVal;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
