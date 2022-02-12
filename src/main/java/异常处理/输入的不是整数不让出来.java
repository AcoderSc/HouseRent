package 异常处理;

import java.util.Scanner;

@SuppressWarnings("all")
public class 输入的不是整数不让出来 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;
        while (true){//不输入整数出不来
            System.out.println("请输入一个整数");
            String intputStr = input.nextLine();
            try {
                num = Integer.parseInt(intputStr);
                break;
            } catch (NumberFormatException e) {
//                e.printStackTrace();//会捕获异常信息
                System.out.println("你输入的不是一个整数，请重新输入!");
            }
        }
        System.out.println("您输入的整数是：" + num);
    }
}
