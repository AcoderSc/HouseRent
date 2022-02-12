package debug;

public class Debug {
    public static void main(String[] args) {
        //演示逐行执行代码
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += i;
            System.out.println(res);
        }
        System.out.println("退出···");
        System.out.println("退出···");
        System.out.println("退出···");
        System.out.println("退出···");
    }
}
