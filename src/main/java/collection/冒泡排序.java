package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 冒泡排序 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("三国演义", 12, "小明"));
        list.add(new Book("水浒",45,"雄安"));
        list.add(new Book("水浒",32,"雄安"));
        bubbleSort(list);
        System.out.println("排序后：" + list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }

    public static void bubbleSort(List list){
        for (int i = 0; i < list.size() -1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Book b1 = (Book)list.get(j);
                Book b2 = (Book)list.get(j+1);
                if (b1.getPrice()<b2.getPrice()){
                    list.set(j, b2);
                    list.set(j+1, b1);
                }
            }
        }
    }
}
class Book{
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
