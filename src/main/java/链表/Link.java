package 链表;

public class Link {
    public static void main(String[] args) {
        Node node1 = new Node(1, "我是", "www");
        Node node2 = new Node(2, "我是", "www");
        Node node3 = new Node(3, "我是", "www");
        Node node4 = new Node(4, "我是", "www");
        LinkOperation linkOperation = new LinkOperation();



        linkOperation.AddNodeByOrder(node4);
        linkOperation.AddNodeByOrder(node3);
        linkOperation.AddNodeByOrder(node2);
        linkOperation.AddNodeByOrder(node1);
        linkOperation.showNode();

    }
}
class LinkOperation{
    Node HeadNode = new Node(0,"","");//头节点！啥也不干！
    public void AddNode(Node AddNode){
        //创建临时节点，替代头节点  辅助变量！
        Node tempNode = HeadNode;
        while (true){//当退出循环时，tempNode指向链表的最后！
            if (tempNode.getNextNode()==null){//遍历找到最后一节点
                break;
            }
            tempNode = tempNode.getNextNode();
        }
        tempNode.setNextNode(AddNode);
    }
    public void AddNodeByOrder(Node AddNode){
        //创建临时节点，替代头节点  辅助变量！
        Node tempNode = HeadNode;
        boolean flag = false;//判断链表中是否存在该元素！
        while (true){//当退出循环时，tempNode指向链表的最后！
            if (tempNode.getNextNode()==null){//遍历找到最后一节点
                break;
            }
            if (tempNode.getNextNode().getNo() > AddNode.getNo()){//此时表示已找到位置
                break;
            }else if (tempNode.getNextNode().getNo() == AddNode.getNo()){
                flag = true;
            }
            tempNode = tempNode.getNextNode();
        }
        if (flag){
            System.out.println("已存在该元素，不能添加");
        }else {
            AddNode.setNextNode(tempNode.getNextNode());
            tempNode.setNextNode(AddNode);
        }
    }

    public void showNode(){
        if (HeadNode.getNextNode()==null){
            System.out.println("该链表为空！");
            return;
        }
        Node tempNode = HeadNode.getNextNode();//临时变量！
        while (true){//
            if (tempNode == null) {
                break;
            }
            System.out.println(tempNode);
            tempNode = tempNode.getNextNode();
        }
    }
}
class Node{
    private int no;
    private String name;
    private String nickname;
    private Node nextNode;

    public Node(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
