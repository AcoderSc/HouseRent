package queue;

import java.util.Scanner;

public class 数组模拟队列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        int res;
        Arrayqueue arrayqueue = new Arrayqueue(3);
        while (loop){
            System.out.println("a~添加数据");
            System.out.println("g~得到数据");
            System.out.println("h~得到头部数据");
            System.out.println("s~展示数据");
            System.out.println("输入其他字符退出程序！");
            System.out.println("请输入选择：");
            char choice = scanner.next().charAt(0);
            switch (choice){
                case 'a':
                    System.out.print("请输入要添加的数据：");
                    res = scanner.nextInt();
                    arrayqueue.add(res);
                    break;
                case 'g':
                    try {
                        res =  arrayqueue.getNum();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        res  = arrayqueue.getHeader();
                        System.out.println("头部是：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    try {
                        arrayqueue.showAll();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("程序已退出~~~");
                    loop = false;
                    break;
            }
        }
    }
}
class Arrayqueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public Arrayqueue(int size){
        maxSize = size;
        front = 0;
        rear = 0;//当前数组的最后一个位置的下一个位置
        arr = new int[size];
    }
    //判断是否满：
    public boolean isFull(){  //2,0,3
        return (rear+maxSize-front)%maxSize== maxSize -1;
    }
    //判断是否为空：
    public boolean isEmpty(){
        return front == rear;
    }
    //添加数据：
    public void add(int addNum){
        if (isFull()) {
            System.out.println("队列已满，不能添加数据！");
            return;
        }
        arr[rear] = addNum;
        rear = (rear + 1)%maxSize;
    }
    //得到数据：
    public int getNum(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据~~");
        }
        int res = arr[front];
        front=(front+1)%maxSize;
        return res;
    }
    //得到队列头部数据：
    public int getHeader() {//头部永远都是front前边的数据！
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取头部~~");
        }
        return arr[front];
    }
    public void showAll(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能展示数据~~");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] + %d",i%maxSize,arr[i%maxSize]);
            System.out.println();
        }
    }
    public int size() {//当前数组的有效数据的个数
        return (rear + maxSize - front)%maxSize; //1,0,3  2,1,3
    }
}
