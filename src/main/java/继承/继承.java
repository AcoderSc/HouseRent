package 继承;

public class 继承 {
    public static void main(String[] args) {
        son son = new son();
        //子类创建对象时，先加载父类的构造方法
//        我是父类有参构造
//        我是子类无参构造

    }
}
class personn{
    private String name;
    public personn(String name) {
        this.name = name;
        System.out.println("我是父类有参构造");
    }

    public personn() {
        System.out.println("我是父类无参构造");
    }
}
class son extends personn{
    public son() {
        super("");
        System.out.println("我是子类无参构造");
    }
}

