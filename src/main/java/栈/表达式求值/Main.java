package 栈.表达式求值;

import java.util.Scanner;

//中缀表达式
public class Main {
    //使用两个栈来完成
    //
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Equation = input.nextLine();
        String keepNumber = "";
        //创建两个栈  数栈和符号栈
        Stack numStack = new Stack(10);
        Stack operStack = new Stack(10);
        int index = 0;//初始化扫描的索引！
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到的char保存到ch；
        while (true) {
            //依次得到Equation的每一个字符
            ch = Equation.substring(index, index + 1).charAt(0);
            //判断ch是啥来做相应的处理
            if (operStack.isOper(ch)) {//如果是运算符
                if (!operStack.isEmpty()) {//不为空，进行比较
                    if (operStack.priority(ch) <= operStack.priority(operStack.seeTop())) {//满足的话
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        //如果当前的操作符的优先级大于栈中的操作符
                        operStack.push(ch);
                    }

                } else {//为空直接入符号栈
                    operStack.push(ch);
                }
            } else {//如果是数字，直接入数栈
                //处理多位数时，需谨慎处理，在处理数时，需要向index后在进行扫描，若发现是字符才能入栈
                //处理多位数：

//                numStack.push(Integer.parseInt(ch+""));//此处这样写会有错误！处理多位数时会出错
                //处理多位数时，须向Equation的后一位继续再看，如果是数字则不能直接入栈，
//                判断下一个字符是否为数字，则进行继续扫描，如果是运算符，则入数栈

                keepNumber += ch;//向后试探一位
                if (index == Equation.length() - 1) {
                    numStack.push(Integer.parseInt(keepNumber));
                } else {
                    if (operStack.isOper(Equation.substring(index + 1, index + 2).charAt(0))) {//是操作符的话
                        numStack.push(Integer.parseInt(keepNumber));//入栈
                        keepNumber = "";
                    }
                }
            }
            index++;
            if (index >= Equation.length()) {
                break;
            }
        }
        while (true) {
            //如果符号栈为空，则已经计算到最后的结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);//结果入栈
        }
        //退出上述while循环时，数栈中就已经只有一个结果数字了
        System.out.println(Equation + "=" + numStack.pop());//将数栈的最后一个数字弹出！
    }
}

//先创建一个栈，
class Stack {
    int maxSize;
    int[] stack;
    int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满了");
            return;
        }
        top++;
        stack[top] = value;
    }

    //查看栈顶元素的方法
    public int seeTop() {
        return stack[top];//返回栈顶元素的值
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        return stack[top--];
    }

    public void list() {
        //遍历：需要从栈顶开始显示数据
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]  %d", i, stack[i]);
            System.out.println();
        }
    }

    //判断符号的优先级  优先级使用数字表示，数字越大，则越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否为一个运算符
    public boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}


