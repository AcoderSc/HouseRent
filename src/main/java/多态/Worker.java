package 多态;

public class Worker extends Employee{
    public Worker(int salary, String name) {
        super(salary, name);
    }
    public void work(){
        System.out.println(getName() +"正在工作！" );
    }

    @Override
    public int getAnnual() {
        return super.getAnnual();
    }
}
