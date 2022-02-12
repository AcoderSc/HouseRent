package HomeWork01;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("小名", '男', 21, "201917607");
        Teacher teacher = new Teacher("老张", '男', 55, 5);
        student.printInfo();
        System.out.println("-------------------");
        teacher.printInfo();
    }
}
