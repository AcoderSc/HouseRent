package 重写equals方法;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private char gender;


//    @Override
//    public boolean equals(Object o){
//        //如果比较的两个对象是同一个对象则返回真
//        if (this == o) {
//            return true;
//        }
//        if (o instanceof Person){ //是Person才比较  向下转型 Object转Person
//            Person p = (Person) o;
//            return this.name.equals(p.name) && this.age == p.age&&this.gender == p.gender;
//        }
//        return false;
//    }

    public Person() {
    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


}
