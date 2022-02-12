package HomeWork01;

public class Student extends Person {
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }
    public void study(){
        System.out.println("我要好好学习！");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }
    public void printInfo(){
        System.out.println("学生信息");
        System.out.println(super.basicInfo());
        study();
        System.out.println(play());
    }
}
