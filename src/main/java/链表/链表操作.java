package 链表;

import java.util.Stack;

public class 链表操作 {
    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1, "小", "1q1");
        LinkNode node2 = new LinkNode(2, "小", "1q1");
        LinkNode node3 = new LinkNode(3, "小", "1q1");
        LinkNode node4 = new LinkNode(3, "完善", "哇塞哇塞w");
        Operation operation = new Operation();
        operation.add(node3);
        operation.add(node1);
        operation.add(node2);
        System.out.println(NodeCount(operation.head));//
        operation.show();
        operation.update(node4);
        System.out.println("~~~~~~");
        operation.show();
        System.out.println(NodeCount(operation.head));//
        System.out.println("~~~~~~");
        operation.show();
        System.out.println(NodeCount(operation.head));//
//        System.out.println(findNoK(2, operation.head));

//        reverse(operation.head);
//        operation.show();
        System.out.println("使用栈~~~~");
        reverseStack(operation.head);
    }
    public static int NodeCount(LinkNode head){
        if (head.next == null){
            return 0;
        }
        int res = 0;
        LinkNode temp = head.next;
        while (temp != null){
            res ++;
            temp = temp.next;
        }
        return res;
    }
    public static LinkNode findNoK(int k,LinkNode head){
        if (head.next == null){
            return null;
        }
        if (k <= 0 || k>NodeCount(head)){
            return null;
        }
        int index = NodeCount(head) - k;//3 1 2
        LinkNode temp = head.next;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public static void reverse(LinkNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        //定义辅助指针；
        LinkNode cur = head.next;
        LinkNode next = null;
        LinkNode reverser = new LinkNode(0,"","");
        //遍历原来的链表，
        while (cur != null){
            next = cur.next;//暂时保留当前节点的下一个节点！
            cur.next = reverser.next;//将cur的下一个节点指向reverser的最前端
            reverser.next = cur;//将reverser的下一个节点指向cur
            cur = next;//向下走
        }
        head.next = reverser.next;
    }
    //堆栈
    public static void reverseStack(LinkNode head){
        if (head.next == null) {
            return;
        }
        LinkNode temp = head.next;
        Stack<LinkNode> stack = new Stack<>();
        while (true){
            if (temp == null) {
                break;
            }
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}

class Operation {
    LinkNode head = new LinkNode(0, "", "");

    public void add(LinkNode node) {
        LinkNode temp = head;//
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;//空链表的话就直接插入！
            }
            if (temp.next.id > node.id) {
                break;
            } else if (temp.next.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("该链表已存在！");
        } else {
            node.next = temp.next;

            temp.next = node;

        }
    }

    public void show() {
        if (head.next == null) {
            System.out.println("该链表为空！");
            return;
        }
        LinkNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //根据编号修改信息！
    public void update(LinkNode newNode) {
        if (head.next == null){
            System.out.println("链表为空！");
            return;//没有阶段
        }
        LinkNode temp = head.next;
        boolean flag = false;//
        while (true){
            if (temp == null){//已经遍历完所有的节点
                break;
            }
            if (temp.id == newNode.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newNode.name;
            temp.nickname = newNode.nickname;
        }else {
            System.out.println("没有该节点！");
        }
    }
    public void delete(int id){
        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }
        boolean flag = false;
        LinkNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到该节点！");
        }
    }
}

class LinkNode {
    int id;
    String name;
    String nickname;
    LinkNode next;

    public LinkNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
