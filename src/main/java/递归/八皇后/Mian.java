package 递归.八皇后;

public class Mian {
    static int max = 4;
    static int sum = 0;
    static int[] arr = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        check(0);  //n从0开始，表示第n个皇后！
        System.out.println(count);
        System.out.println(sum);
    }
    //判断放置的皇后和之前n-1的皇后是否冲突   放置皇后
    public static void check(int n){ //n = 0 1 2 3 4 5 6 7
        if (n == max){
            print();
            count ++;
            return;
        }
        //依次放入皇后
        for (int i = 0; i < max; i++) {
            arr[n] = i;//先将当前的皇后放在第0列
            if (panduan(n)){//不冲突
                check(n+1);//放n+1个
            }
//            else 冲突的话 就执行 arr[n] = i; i++,跳过冲突位置，后移
        }
    }
    /**
     *
     * @param n
     * @return
     */
    public static boolean panduan(int n){
        for (int i = 0; i < n; i++) {
            //arr[i] == arr[n] 表示判断n是否和n-1的在同一列
            //Math.abs(n-i) == Math.abs(arr[n]-arr[i]  n = 1 ,i = 0,表示第2个皇后和第1个皇后作比较，arr[n]-arr[i] = 1 - 0
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])){//判断是否在同一列或 同一斜线
                return false;
            }
        }
        return true;
    }
    //将数组打印的方法
    public static void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
