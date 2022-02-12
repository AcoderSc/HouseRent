public class 字符串反转 {
    public static void main(String[] args) {//程序的健壮性！
        String string = "123456";
        System.out.print("交换前：");
        System.out.println(string);
        try {
            string = reverse(null, 0, 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());//输出错误信息
            System.exit(0);//相当于return
        }
        System.out.print("交换后：");
        System.out.println(string);
    }

    public static String reverse(String string, int begin, int end) {
        if (!(string != null&&begin >= 0 && end < string.length() && begin < end )) {
            throw new RuntimeException("输入的参数有误！");
        }
        char[] chars = string.toCharArray();
        for (int i = begin, j = end; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}

