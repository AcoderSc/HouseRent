package 集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 集合遍历 {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add(new Dog("小白", 1));
        arrayList.add(new Dog("小明",2));
        arrayList.add("123");

        for (Object o : arrayList) {
            System.out.println(o);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object dog = iterator.next();
            System.out.println(dog);
        }


    }
}
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
