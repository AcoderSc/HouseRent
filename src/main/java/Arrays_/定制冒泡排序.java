package Arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class 定制冒泡排序 {
    public static void main(String[] args) {
        Integer[] a = {8,4,23,3,78,7};
        bubbleSort(a, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2-i1;
            }
        });
        System.out.println(Arrays.toString(a));

    }
    public static void bubbleSort(Integer[] a, Comparator c){
        for (int i = 0; i< a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 -i; j++) {
                if (c.compare(a[j],a[j+1])>0){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
