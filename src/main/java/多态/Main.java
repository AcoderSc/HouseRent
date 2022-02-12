package 多态;

public class Main {
    public static void main(String[] args) {
        Worker 小明 = new Worker(5000, "小明");
        Manager 小红 = new Manager(20000, "小红", 2000000);
        Main main = new Main();
        main.printAnnual(小明);
        main.printAnnual(小红);
        main.duty(小明);
        main.duty(小红);
    }
    public void printAnnual(Employee e){
        System.out.println(e.getAnnual());
    }
    public void duty(Employee e){
        if (e instanceof Worker){
            ((Worker) e).work();
        }else if (e instanceof Manager){
            ((Manager) e).manager();
        }else {
            System.out.println("啥也不干！");
        }
    }
}
