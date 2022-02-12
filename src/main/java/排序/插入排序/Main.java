package 排序.插入排序;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {4, 2, 70, 9, 43};
        //逐步简化
//          第一步：2, 4, 5, 9, 1, 5\
        for (int i = 1; i < a.length; i++) {
            int insertVal = a[i];//待插入的数
            int insertindex = i - 1;//待插入的数的下标
//        insertVal<a[insertindex]表示没有找到插入位置
            while (insertindex >= 0 && insertVal < a[insertindex]) {
                //搜寻前n-1个位置，确认插入位置
                a[insertindex + 1] = a[insertindex];
                //后移
                insertindex--;
            }
            //循环退出时，说明插入的位置找到了
            // 位置是insertindex + 1；
            a[insertindex + 1] = insertVal;
            System.out.println(Arrays.toString(a));
        }

    }
}
