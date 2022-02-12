package 链表.单向循环链表;

import javax.swing.*;

public class Mian {
    public static void main(String[] args) {
        Operation op = new Operation();
        op.add(5);
        op.listnode();
        op.Solution(1, 5, 2);
    }
}
class Operation{
    Node first = null;
    public void add(int addnums){//添加节点操作
        if (addnums < 1){
            System.out.println("输入的添加数字有误！");
            return;
        }
        Node cur = null;
        for (int i = 1; i <=addnums;  i++) {
            Node node = new Node(i);
            if (i == 1){//首先创建第一个节点
                first = node;
                first.next = first;
                cur = first;
            }else {
                cur.next = node;
                node.next = first;
                cur = node;
            }
        }
    }
    public void listnode(){
        if (first == null){
            return;
        }
        Node temp = first;
        while (true) {
            System.out.println(temp.id);
            if (temp.next == first){//已经到达最后一个节点
                break;
            }
            temp = temp.next;
        }
    }
    public void Solution(int begin,int tollNumber,int count){
        if (tollNumber<1||count>tollNumber||begin<1){
            return;
        }
        if (first == null){
            return;
        }
        Node helper = first;
        while (true){
            if (helper.next == first){
                break;
            }
            helper = helper.next;
        }
        //help现已经指向最后的节点
        for (int i = 0; i < begin - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        while (true){
            if (first == helper){//到达最后
                break;
            }//1 2 3 4 5
            for (int i = 0; i < count -1; i++) {
                first = first.next;
                helper = helper.next;
            }//first即为要删除的
            System.out.println("出圈节点是："  + first.id);
            first = first.next;
            helper.next = first;
        }
        System.out.println("出圈节点是："  + first.id);



    }
}
class Node{
    int id;
    Node next;

    public Node(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}
