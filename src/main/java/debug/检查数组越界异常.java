package debug;

public class 检查数组越界异常 {
    public static void main(String[] args) {
        int[] a = new int[] {0, 1, 2};
        for (int i = 0; i <= a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("已经退出");
    }
}
