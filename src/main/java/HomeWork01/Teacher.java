package HomeWork01;

public class Teacher extends Person{
    private int work_year;

    public Teacher(String name, char sex, int age, int work_year) {
        super(name, sex, age);
        this.work_year = work_year;
    }
    public void teach() {
        System.out.println("我会好好教书！");
    }
    @Override
    public String play() {
        return super.play() + "象棋";
    }

    public void printInfo(){
        System.out.println("老师信息");
        System.out.println(super.basicInfo());
        teach();
        System.out.println(play());
    }


}
