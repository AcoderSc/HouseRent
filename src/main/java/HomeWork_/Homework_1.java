package HomeWork_;
import java.util.HashSet;
import java.util.Objects;
public class Homework_1 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person p1 = new Person(2,"AA");
        Person p2 = new Person(1002,"BB");
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet);
        System.out.println(p1.hashCode());
        p1.name = "CC";
        System.out.println(p1.hashCode());
        hashSet.remove(p1);
        System.out.println(hashSet);
        hashSet.add(new Person(1001, "CC"));
        System.out.println(hashSet);
        hashSet.add(new Person(1001,"AA"));
        System.out.println(hashSet);

        Person p3 = new Person(1001, "22");
        Person p4 = new Person(1001, "22");
        System.out.println(p3.hashCode());
        System.out.println(p4.hashCode());
    }
}
class Person{
    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {//比较的是对象的内容是否相同!
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {//对象的id和name相同时，返回相同的hashCode();
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
