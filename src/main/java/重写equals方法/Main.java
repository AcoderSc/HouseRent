package 重写equals方法;

public class Main {
    public static void main(String[] args) {
        Integer a = new Integer(12);
        Integer b = new Integer(12);
        System.out.println(a.equals(b));//true
        System.out.println(a == b);//false
        String s1 = new String("123");
        String s2 = new String("123");
        System.out.println(s1.equals(s2));//true
        System.out.println(s1 == s2);//false

        System.out.println(67.0f == 67);
        System.out.println(67L == 67);
        System.out.println(67.000 == 67);
        char ch1 = 12;
        System.out.println(12==ch1);
    }
}
