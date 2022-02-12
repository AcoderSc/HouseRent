package 房屋出租系统.utils;

public class Test {
    public static void main(String[] args) {
        String s =Utility.readString(3);
        System.out.println(s);
        String s1 = Utility.readString(3,"123456");
        System.out.println(s1);
        char x = Utility.readChar('1');
        System.out.println(x);
    }
}
