package Arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class 定制排序 {
    public static void main(String[] args) {
        Integer[] a = {4,8,2,4,6};
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(Arrays.toString(a));
    }
}
