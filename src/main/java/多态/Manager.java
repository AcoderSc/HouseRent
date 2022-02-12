package 多态;

public class Manager extends Employee{
    int bonus;

    public Manager(int salary, String name, int bonus) {
        super(salary, name);
        this.bonus = bonus;
    }
    public void manager() {
        System.out.println(getName() + "正在管理");
    }
    @Override
    public int getAnnual() {
        return super.getAnnual() + bonus;
    }
}
