public class Finalize {
    public static void main(String[] args) {
        Car car = new Car("宝马");
        car = null;//此时car对象就是一个垃圾  垃圾回收器就会回收（销毁）
        System.gc();//主动调用垃圾回收机制
        System.out.println("程序退出了···");
    }
}
class Car{
    private String name;
    public Car(String name) {
        this.name = name;
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("我们销毁了汽车" + name);
    }
}
