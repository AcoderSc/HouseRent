public class HashCode {
    public static void main(String[] args) {
        AA a1 = new AA();
        AA a2 = new AA();
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1.toString());


    }
}
class AA{
    private int aged;

    @Override
    public String toString() {
        return "AA{" +
                "aged=" + aged +
                '}';
    }
}