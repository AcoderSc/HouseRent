package 链表.约瑟夫环问题;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Circle circle = new Circle();
//        circle.listBoy();
//        public void countBoy(int start, int countNum, int nums) {//start表示从第几个小孩开始数数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        circle.addBoy(n);
        circle.countBoy(1, k, n);
    }
}

//创建环形链表
class Circle {
    //创建first节点，当前没有编号
    private Boy first = null;

    //添加小孩节点，构成环形链表
    public void addBoy(int nums) {//nums表示几个节点
        //对nums做约束
        if (nums < 1) {
            System.out.println("数据不正确！");
            return;
        }
        Boy curboy = null;//辅助变量   帮助构建环型变量！
        //循环创建链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);//创建节点
            //如果是第一个小孩，
            if (i == 1) {
                first = boy;//first始终指向第一个孩子节点！  不能移动
                first.setNext(first);//构成一个环状、、
                curboy = first;//让curboy指向第一个小孩。。first不能动！  使用curboy来创建
            } else {
                curboy.setNext(boy);//
                boy.setNext(first);//让与第一个first相连
                curboy = boy;//curboy后移，指向当前孩子节点
            }
        }
    }

    public void listBoy() {
        //判断是否为空
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
//        辅助指针
        Boy temp = first;
        while (true) {
            System.out.println("小孩的编号" + temp.getNo());
            if (temp.getNext() == first) {//说明已经遍历完成
                break;
            }
            temp = temp.getNext();
        }
    }

    //根据用户输入，计算出圈的顺序
    public void countBoy(int start, int countNum, int nums) {//start表示从第几个小孩开始数数
        //countNum 表示数到几的小孩出圈，nums表示最开始的小孩数量
        if (first == null || start < 1 || start > nums) {
            System.out.println("参数输入有误！");
            return;
        }
        //创建辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //先让
        while (true) {
            if (helper.getNext() == first) {//
                break;
            }
            helper = helper.getNext();//
        }
        //helper此时指向了最后一个小孩节点！

        //报数前，先将first和helper移动到指定位置，移动到第start的小孩处。
        for (int i = 0; i < start - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper同时移动m-1次，1 2 3 4 5
        // 此时first指向的节点就是出圈的节点然后出圈
        while (true) {
            if (helper == first) {//只有圈中只有一个节点
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时，first指向的节点就是出圈的节点
//            System.out.println("出圈的结点的是：" + first.getNo());
            //出圈操作:
            first = first.getNext();
            helper.setNext(first);
        }
        //输出最后的一个节点
        System.out.println(helper.getNo());
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
