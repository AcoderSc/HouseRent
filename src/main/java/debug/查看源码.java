package debug;

import java.util.Arrays;

public class 查看源码 {
    public static void main(String[] args) {
        int[] a = {
            1,5,354,2
        };
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + "\t");
        }
    }
}
