package 栈.单链表模拟栈;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack(12);
        boolean loop = true;
        while (loop){
            System.out.println("u~入栈");
            System.out.println("o~出栈");
            System.out.println("l~遍历栈");
            char choice = scanner.next().charAt(0);
            switch (choice){
                case 'u':
                    System.out.println("请输入数字：");
                    int val = scanner.nextInt();
                    stack.push(val);
                    break;
                case 'o':
                    try {
                        System.out.println(stack.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'l':
                    stack.list();
                    break;
                default:
                    loop = false;
                    System.out.println("程序已退出");
                    break;
            }

        }


    }
}
class Stack{
    int maxSize;
    int[] stack;
    int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //
    public boolean isFull() {
        return top == maxSize-1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满了");
            return;
        }
        top ++;
        stack[top] = value;
    }
    public int pop() {
        if (isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        return stack[top--];
    }
    public void list(){
        //遍历：需要从栈顶开始显示数据
        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]  %d",i,stack[i]);
            System.out.println();
        }

    }
}
