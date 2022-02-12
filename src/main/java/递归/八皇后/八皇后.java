package 递归.八皇后;

public class 八皇后 {
    static int max = 8;
    static int count = 0;
    static int[] arr = new int[max];
    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }
    public static void check(int n){
        if (n == max){
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (!panduanp(n)){
                check(n+1);
            }
        }
    }
    public static boolean panduanp(int n){
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[i] - arr[n])){
                return true;
            }
        }
        return false;

    }
    public static void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
